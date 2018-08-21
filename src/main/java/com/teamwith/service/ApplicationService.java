package com.teamwith.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamwith.dao.ApplicantDAO;
import com.teamwith.dao.ApplicationDAO;
import com.teamwith.dao.InterviewAnswerDAO;
import com.teamwith.dao.InterviewDAO;
import com.teamwith.dao.InterviewQuestionDAO;
import com.teamwith.dao.MyApplicationDAO;
import com.teamwith.dto.ApplicationDTO;
import com.teamwith.dto.InterviewAnswerDTO;
import com.teamwith.dto.InterviewQuestionDTO;
import com.teamwith.vo.ApplicantVO;
import com.teamwith.vo.ApplicationVO;
import com.teamwith.vo.InterviewVO;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.MyApplicationVO;

@Service
public class ApplicationService {
	@Inject
	private InterviewDAO interviewDAO;
	@Inject
	private MyApplicationDAO myApplicationDAO;
	@Inject
	private ApplicationDAO applicationDAO;
	@Inject
	private ApplicantDAO applicantDAO;
	@Inject
	private InterviewQuestionDAO interviewQuestionDAO;
	@Inject
	private InterviewAnswerDAO interviewAnswerDAO;

	public List<InterviewVO> getMyInterview(String applicationId) {
		List<InterviewVO> result = interviewDAO.searchInterview(applicationId);
		return result;
	}

	public List<MyApplicationVO> getMyApplication(String memberId) {
		List<MyApplicationVO> result = null;
		try {
			result = myApplicationDAO.searchMyApplication(memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 내 상태가 합류된 팀 아이디..
	public List<String> getJoinedTeamId(String memberId) {
		List<String> result = new ArrayList<String>();
		try {
			List<ApplicationDTO> applications = applicationDAO.searchApplicationByMemberId(memberId);
			for (ApplicationDTO application : applications) {
				if (application.getApplicationStatus() == 1)
					result.add(application.getTeamId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<ApplicantVO> getApplicant(String teamId) {
		List<ApplicantVO> result = null;
		try {
			result = applicantDAO.searchApplicantByTeamId(teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<InterviewVO> getInterview(String teamId) {
		List<InterviewVO> result = interviewDAO.searchInterviewAll(teamId);
		return result;
	}

	public List<InterviewQuestionDTO> getInterviewQuestion(String teamId) {
		List<InterviewQuestionDTO> result = null;
		try {
			result = interviewQuestionDAO.searchInterviewQuestionByTeamId(teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int changeApplicationStatus(int status, String applicationId) {
		ApplicationDTO application = new ApplicationDTO();
		application.setApplicationStatus(status);
		application.setApplicationId(applicationId);
		int result = 0;
		try {
			result = applicationDAO.updateApplicationStatusByApplicationId(application);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int registerInteviewQuestion(List<InterviewVO> interviewQuestion) {
		int result = 0;
		for (InterviewVO interview : interviewQuestion) {
			InterviewQuestionDTO question = new InterviewQuestionDTO();
			List<String> keys;
			try {
				keys = interviewQuestionDAO.getInterviewQuestionId();
				String id = generateId(keys, "interview_question");
				question.setInterviewQuestionId(id);
				question.setTeamId(interview.getTeamId());
				question.setInterviewQuestionContent(interview.getInterviewQuestionContent());
				result = interviewQuestionDAO.addInterviewQuestion(question);
			} catch (Exception e) {
				result = 0;
				e.printStackTrace();
			}
		}
		return result;
	}

	@Transactional
	public void applyTeam(ApplicationVO application, List<InterviewVO> interviewAnswer) {
		String appId = applyTeam(application);
		for (InterviewVO vo : interviewAnswer) {
			vo.setApplicationId(appId);
		}
		applyTeam(interviewAnswer);

	}

	public String applyTeam(ApplicationVO application) {
		ApplicationDTO applicationDTO = null;
		String id = null;
		try {
			applicationDTO = application.toDTO();
			id = generateId(applicationDAO.getApplicationId(), "application");
			applicationDTO.setApplicationId(id);
			applicationDAO.addApplication(applicationDTO);
		} catch (Exception e) {
			e.printStackTrace();
			id = null;
		}
		return id;
	}

	public int applyTeam(List<InterviewVO> interviewAnswer) {
		int result = 0;
		try {
			for (InterviewVO interview : interviewAnswer) {
				InterviewAnswerDTO interviewDTO = new InterviewAnswerDTO();
				List<String> interviewIds = interviewAnswerDAO.getInterviewAnswerId();
				String id = generateId(interviewIds, "interview_answer");
				interviewDTO.setApplicationId(interview.getApplicationId());
				interviewDTO.setInterviewAnswerContent(interview.getInterviewAnswerContent());
				interviewDTO.setInterviewAnswerId(id);
				interviewDTO.setInterviewQuestionId(interview.getInterviewQuestionId());
				result = interviewAnswerDAO.addInterviewAnswer(interviewDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<MemberSearchVO> getTeamMember(String teamId) {
		List<MemberSearchVO> result = null;
		try {
			List<ApplicantVO> applicants = applicantDAO.searchApplicantByTeamId(teamId);
			result = new ArrayList<MemberSearchVO>();
			for (ApplicantVO applicant : applicants) {
				if (Integer.parseInt(applicant.getApplicationStatus()) == 1) {
					MemberSearchVO teamMember = new MemberSearchVO();
					teamMember.setMemberId(applicant.getMemberId());
					teamMember.setMemberName(applicant.getMemberName());
					teamMember.setMemberPic(applicant.getMemberPic());
					result.add(teamMember);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private String generateId(List<String> id, String tableName) {
		if (id == null) {
			return tableName + "-" + 1;
		}

		int maxCnt = -1;

		for (String str : id) {
			if (maxCnt < Integer.parseInt(str.split("-")[1])) {
				maxCnt = Integer.parseInt(str.split("-")[1]);
			}
		}

		return tableName + "-" + (maxCnt + 1);
	}
}

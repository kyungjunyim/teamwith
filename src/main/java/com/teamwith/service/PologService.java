package com.teamwith.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Part;

import org.springframework.stereotype.Service;

import com.teamwith.dao.PologDAO;
import com.teamwith.dao.PortfolioContentDAO;
import com.teamwith.dao.PortfolioDAO;
import com.teamwith.dao.PortfolioSimpleDAO;
import com.teamwith.dto.PologDTO;
import com.teamwith.dto.PortfolioContentDTO;
import com.teamwith.dto.PortfolioDTO;
import com.teamwith.util.Criteria;
import com.teamwith.util.UploadFileUtils;
import com.teamwith.vo.PologVO;
import com.teamwith.vo.PortfolioContentVO;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.PortfolioVO;
@Service
public class PologService {
	@Inject
	private PologDAO pologDAO;
	@Inject
	private PortfolioDAO portfolioDAO;
	@Inject
	private PortfolioContentDAO portfolioContentDAO;
	@Inject
	private PortfolioSimpleDAO portfolioSimpleDAO;

	public List<PortfolioSimpleVO> getPortfolioList(String memberId) {
		if (memberId == null || memberId.isEmpty()) {
			return null;
		}
		List<PortfolioSimpleVO> portfolioSimpleList = null;
		boolean check = true;
		try {
			portfolioSimpleList = portfolioSimpleDAO.searchPortfolioSimpleByMemberId(memberId);
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			if (!check)
				return null;
		}
		return portfolioSimpleList;
	}

	public List<PortfolioSimpleVO> getRecentPortfolio(Criteria cri) {
		if (cri == null) {
			return null;
		}
		List<PortfolioSimpleVO> portfolioSimpleList = null;
		boolean check = true;
		try {
			portfolioSimpleList = portfolioSimpleDAO.searchPortfolioSimpleAll(cri);

		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			if (!check)
				return null;
		}
		return portfolioSimpleList;
	}
	/**포폴 검색*/
	public List<PortfolioSimpleVO> searchPortfolio(Criteria cri) {
		if (cri == null ) {
			return null;
		}
		List<PortfolioSimpleVO> portfolioSimpleList = null;
		boolean check = true;
		try {
			
			portfolioSimpleList = portfolioSimpleDAO.searchPortfolio(cri);
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			if (!check)
				return null;
		}
		return portfolioSimpleList;
	}
	/**포폴컨텐츠랑 포폴 한방에 등록*/
	public boolean registerPortfolioAndContent(Map<Object,Part> portfolioAndContent) {
		if(portfolioAndContent==null) {
			return false;
		}
		boolean check = true;
		Iterator<Object> it=portfolioAndContent.keySet().iterator();
		try {
			while(it.hasNext()) {
				Object obj=it.next();
				if(obj instanceof PortfolioVO) {
					this.registerPortfolio((PortfolioVO)obj,portfolioAndContent.get(obj) );
				}else if(obj instanceof PortfolioContentVO){
					this.registerPortfolioContent((PortfolioContentVO)obj,portfolioAndContent.get(obj) );
				}
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
			check=false;
		} 
		
		return check;
	}
	/**포폴컨텐츠 하나씩 등록*/
	public int registerPortfolioContent(PortfolioContentVO portfolioContent, Part file) {
		if (portfolioContent == null) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			List<String> portfolioContentId = portfolioContentDAO.getId();
			portfolioContent.setPortfolioContentId(this.generateId(portfolioContentId, "portfolio_content"));
			int r = portfolioContentDAO.addPortfolioContent(portfolioContent.toDTO());
			if (r != 0) {
				if (file != null) {
					UploadFileUtils.uploadFile("C:\\teamwith\\image\\portfolio\\" + portfolioContent.getPortfolioId(),
							portfolioContent.getPortfolioContentId(), file);
				}
			}

		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			if (!check)
				return 0;
		}
		return res;
	}
	/**포폴컨텐츠 한방에 등록*/
	public boolean registerPortfolioContents(Map<PortfolioContentVO,Part> portfolioContents) {
		if(portfolioContents==null) {
			return false;
		}
		int res=0;
		boolean check=true;
		try {
			Iterator<PortfolioContentVO> it=portfolioContents.keySet().iterator();
			while(it.hasNext()) {
				PortfolioContentVO pc=it.next();
				int r=this.registerPortfolioContent(pc,portfolioContents.get(pc));
				if(r!=0) {
					res++;
				}
			}
		} catch (Exception e) {
			check=false;
			e.printStackTrace();
		}
		finally {
			if(!check)
				return false;
		}
		if(res==portfolioContents.size()) {
			return true;
		}else {
			return false;
		}
	}

	public int registerPortfolio(PortfolioVO portfolio,Part file) {
		if (portfolio == null) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			List<String> portfolioId = portfolioDAO.getId();
			portfolio.setPortfolioId(this.generateId(portfolioId, "portfolio"));
			res = portfolioDAO.addPortfolio(portfolio.toDTO());
			if(res!=0) {
				if(file!=null) {
					UploadFileUtils.uploadFile("C:\\teamwith\\image\\portfolio\\"+portfolio.getPortfolioId(),portfolio.getPortfolioId(), file);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return 0;
		}
		return res;
	}

	public int removePortfolio(String portfolioId) {
		if (portfolioId == null || portfolioId.isEmpty()) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			res = portfolioDAO.removePortfolioByPortfolioId(portfolioId);
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return 0;
		}
		return res;
	}

	public int updatePortfolioContent(PortfolioContentVO portfolioContent,Part file) {
		if (portfolioContent == null) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			res = portfolioContentDAO.updatePortfolioContent(portfolioContent.toDTO());
			if(res!=0) {
				if(file!=null) {
					UploadFileUtils.uploadFile("C:\\teamwith\\image\\portfolio\\" + portfolioContent.getPortfolioId(),
							portfolioContent.getPortfolioContentId(), file);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return 0;
		}
		return res;
	}

	public int updatePortfolio(PortfolioVO portfolio,Part file) {
		if (portfolio == null) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			res = portfolioDAO.updatePortfolio(portfolio.toDTO());
			if(res!=0) {
				if(file!=null) {
					UploadFileUtils.uploadFile("C:\\teamwith\\image\\portfolio\\" + portfolio.getPortfolioId(),
							portfolio.getPortfolioId(), file);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return 0;
		}
		return res;
	}

	public List<PortfolioContentVO> getPortfolioContent(String portfolioId) {
		if (portfolioId == null || portfolioId.isEmpty()) {
			return null;
		}
		List<PortfolioContentVO> list = new ArrayList<PortfolioContentVO>();
		boolean check = true;
		try {
			List<PortfolioContentDTO> templist = portfolioContentDAO.searchPortfolioContentByPortfolioId(portfolioId);
			if (templist != null) {
				for (PortfolioContentDTO p : templist) {
					list.add(p.toVO());
				}
			} else {
				check = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!check)
				return null;
		}
		return list;
	}

	public PortfolioVO getPortfolio(String portfolioId) {
		if (portfolioId == null || portfolioId.isEmpty()) {
			return null;
		}
		PortfolioVO portfolio = null;
		boolean check = true;
		try {
			PortfolioDTO tempportfolio = portfolioDAO.searchPortfolioByPortfolioId(portfolioId);
			if (tempportfolio != null) {
				portfolio = tempportfolio.toVO();
			} else {
				check = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return null;
		}
		return portfolio;
	}

	public int removePortfolioContent(String portfolioContentId) {
		if (portfolioContentId == null || portfolioContentId.isEmpty()) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			res = portfolioContentDAO.removePortfolioContentByPortfolioId(portfolioContentId);
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return 0;
		}
		return res;
	}

	public int removePortfolioContent(String portfolioId, int flag) {
		if (portfolioId == null || portfolioId.isEmpty()) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			res = portfolioContentDAO.removePortfolioContentByPortfolioId(portfolioId);
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return 0;
		}
		return res;
	}

	public PologVO getPologInfo(String memberId) {
		if (memberId == null || memberId.isEmpty()) {
			return null;
		}
		PologVO polog = null;
		boolean check = true;
		try {
			PologDTO temppolog = pologDAO.searchPologByMemberId(memberId);
			if (temppolog != null) {
				polog = temppolog.toVO();
			} else {
				check = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return null;
		}

		return polog;
	}

	public int updatePolog(PologVO polog,Map<String,Part> files) {
		if (polog == null||files==null) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			res = pologDAO.updatePolog(polog.toDTO());
			if(res!=0) {
				if(files.get("pologIntroPic")!=null) {
					UploadFileUtils.uploadFile("c:\\teamwith\\image\\polog\\"+polog.getMemberId(),"pin-"+polog.getMemberId(), files.get("pologIntroPic"));
				}
				if(files.get("pologBgPic")!=null) {
					UploadFileUtils.uploadFile("c:\\teamwith\\image\\polog\\"+polog.getMemberId(),"pbg-"+polog.getMemberId(), files.get("pologBgPic"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return 0;
		}
		return res;
	}

	public int removePolog(String memberId) {
		if (memberId == null || memberId.isEmpty()) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			res = pologDAO.removePolog(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return 0;
		}
		return res;
	}

	public int removePortfolio(String memberId, int flag) {
		if (memberId == null || memberId.isEmpty()) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			res = portfolioDAO.removePortfolioByMemberId(memberId);
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return 0;
		}
		return res;
	}

	public int createPolog(String memberId) {
		if (memberId == null || memberId.isEmpty()) {
			return 0;
		}
		int res = 0;
		boolean check = true;
		try {
			res = pologDAO.addPologByMemberId(memberId);
			
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		} finally {
			if (!check)
				return 0;
		}
		return res;
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

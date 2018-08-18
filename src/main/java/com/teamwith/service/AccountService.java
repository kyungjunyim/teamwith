package com.teamwith.service;

public class AccountService {
	private static AccountService accountService;
/*

	private MemberService memberService;
	private PologService pologService;
	private ProfileService profileService;
	private ApplicationService applicationService;

	static {
		accountService = new AccountService();
	}

	private AccountService() {
		memberService = MemberService.getInstance();
		pologService = PologService.getInstance();
		profileService = ProfileService.getInstance();
		applicationService = ApplicationService.getInstance();

		String file = "com/teamwith15/config/config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		factory = new SqlSessionFactoryBuilder().build(is);
	}

	public static AccountService getInstance() {
		if (accountService == null) {
			accountService = new AccountService();
		}
		return accountService;
	}

	public void openSession() {
		session = factory.openSession();
	}

	public void commitSession() {
		session.commit();
	}

	public void closeSession() {
		session.close();
	}

	public int updatePassword(String memberId, String memberPassword, String newPassword) throws Exception {
		if (memberId == null || memberPassword == null || newPassword == null) {
			return -1;
			// ����� �ͼ��� ó���ϸ� ���� ��
		}
		Map<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("memberId", memberId);
		loginInfo.put("memberPassword", memberPassword);
		loginInfo.put("newPassword", newPassword);
		return profileService.updatePassword(loginInfo);
	}

	public String findAccount(String memberId, String memberBirth, String memberEmail) throws Exception {
		if (memberBirth == null || memberEmail == null) {
			return null;
			// ����� �ͼ��� ó���ϸ� ���� ��
		}
		Map<String, String> accountInfo = new HashMap<String, String>();
		accountInfo.put("memberId", memberId);
		accountInfo.put("memberBirth", memberBirth);
		accountInfo.put("memberEmail", memberEmail);

		return profileService.searchMemberAccount(accountInfo);
	}

	public String findAccount(String memberBirth, String memberEmail) throws Exception {
		return findAccount(null, memberBirth, memberEmail);
	}

	public void registerMember(MemberVO member) {
		profileService.registerMember(member);
		pologService.createPolog(member.getMemberId());
	}

	public void hideMember(String memberId) {
		profileService.hideMember(memberId);
		List<MyApplicationVO> myApp = applicationService.getMyApplication(memberId);
		List<String> appIds = new ArrayList<String>();
		for (MyApplicationVO m : myApp) {
			if (m.getApplicationStatus().equals("0")) {
				appIds.add(m.getApplicationId());
			}
		}
		for (String appId : appIds) {
			applicationService.changeApplicationStatus(3, appId);
		}
	}

	public void removeMember(String memberId) throws Exception {
		memberService.removeMemberPraise(memberId);
		memberService.removeMemberProjectCategory(memberId);
		memberService.removeMemberSkill(memberId);
		profileService.removeMemberCareer(memberId);
		profileService.removeMemberLicense(memberId);
		profileService.removeMemberTendency(memberId);
		pologService.removePortfolio(memberId, 0);
		pologService.removePolog(memberId);
		profileService.removeMember(memberId);
	}
*/
}

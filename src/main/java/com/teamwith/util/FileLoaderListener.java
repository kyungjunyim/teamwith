package com.teamwith.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.ContextLoaderListener;

@WebListener
public class FileLoaderListener extends ContextLoaderListener {

	Map<String, String> praises = new HashMap<String, String>();
	Map<String, String> projects = new HashMap<String, String>();
	Map<String, String> regions = new HashMap<String, String>();
	Map<String, String> roles = new HashMap<String, String>();
	Map<String, String[]> skills = new HashMap<String, String[]>();
	Map<String, String> developerSkills = new HashMap<String, String>();
	Map<String, String> plannerSkills = new HashMap<String, String>();
	Map<String, String> designerSkills = new HashMap<String, String>();
	Map<String, String> etcSkills = new HashMap<String, String>();
	Map<String, String> tendencies = new HashMap<String, String>();

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		praises = sortByComparator(praises);
		sc.setAttribute("praiseList", praises);
		projects = sortByComparator(projects);
		sc.setAttribute("projectList", projects);
		regions = sortByComparator(regions);
		sc.setAttribute("regionList", regions);
		roles = sortByComparator(roles);
		sc.setAttribute("roleList", roles);
		developerSkills = sortByComparator(developerSkills);
		sc.setAttribute("developerSkillList", developerSkills);
		plannerSkills = sortByComparator(plannerSkills);
		sc.setAttribute("plannerSkillList", plannerSkills);
		designerSkills = sortByComparator(designerSkills);
		sc.setAttribute("designerSkillList", designerSkills);
		etcSkills = sortByComparator(etcSkills);
		sc.setAttribute("etcSkillList", etcSkills);
		skills = sortByComparator(skills, 1);
		sc.setAttribute("skillList", skills);
		tendencies = sortByComparator(tendencies);
		sc.setAttribute("tendencyList", tendencies);
	}

	public void readFile() throws IOException {
		File praise = new File("c:/data/categories/praise.txt");
		File project = new File("c:/data/categories/project.txt");
		File region = new File("c:/data/categories/region.txt");
		File role = new File("c:/data/categories/role.txt");
		File skill = new File("c:/data/categories/skill.txt");
		File tendency = new File("c:/data/categories/tendency.txt");

		File[] files = new File[] { praise, project, region, role, tendency };
		Object[] maps = new Object[] { praises, projects, regions, roles, tendencies };

		for (int i = 0; i < files.length; i++) {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(files[i]), "euc-kr"));
			String line = null;
			while ((line = br.readLine()) != null) {
				String key = line.split("/")[0];
				String value = line.split("/")[1];
				((Map<String, String>) maps[i]).put(key, value);
			}
			br.close();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(skill), "euc-kr"));
		String line = null;
		while ((line = br.readLine()) != null) {
			String key = line.split("/")[0];
			String val1 = line.split("/")[1];
			String val2 = line.split("/")[2];
			skills.put(key, new String[] {val1, val2});
			switch (val2) {
			case "role-1":
				developerSkills.put(key, val1);
				break;
			case "role-2":
				designerSkills.put(key, val1);
				break;
			case "role-3":
				plannerSkills.put(key, val1);
				break;
			case "role-4":
				etcSkills.put(key, val1);
				break;				
			}
		}
		br.close();
	}
	
	private static Map<String, String> sortByComparator(Map<String, String> unsortMap) {

		List<Entry<String, String>> list = new LinkedList<Entry<String, String>>(unsortMap.entrySet());

		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<String, String>>() {
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				Integer v1 = Integer.parseInt(o1.getKey().split("-")[1]);
				Integer v2 = Integer.parseInt(o2.getKey().split("-")[1]);
				
				return v1.compareTo(v2);
			}
		});

		// Maintaining insertion order with the help of LinkedList
		Map<String, String> sortedMap = new LinkedHashMap<String, String>();
		for (Entry<String, String> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
	
	private static Map<String, String[]> sortByComparator(Map<String, String[]> unsortMap, int mode) {

		List<Entry<String, String[]>> list = new LinkedList<Entry<String, String[]>>(unsortMap.entrySet());

		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<String, String[]>>() {
			public int compare(Entry<String, String[]> o1, Entry<String, String[]> o2) {
				Integer v1 = Integer.parseInt(o1.getKey().split("-")[1]);
				Integer v2 = Integer.parseInt(o2.getKey().split("-")[1]);
				
				return v1.compareTo(v2);
			}
		});

		// Maintaining insertion order with the help of LinkedList
		Map<String, String[]> sortedMap = new LinkedHashMap<String, String[]>();
		for (Entry<String, String[]> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
}

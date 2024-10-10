package com.lhj.sep274m.main;

import org.json.simple.parser.JSONParser;
import org.xmlpull.v1.XmlPullParser;

//MyBatis(3.x)
//구) iBatis(2.x)
//Java + DB 유지보수하기 좋게 해주는 framework
//쌩JDBC -> ConnectionPool -> MyBatis

//Java : 전세계적으로 많이 사용함
//개발자들이 작업한거 공유하는 문화
//인터넷에서 남이 공유한거 받아와서 프로젝트에 넣고...
//-> 발전해서 중앙제어시스템(Maven, Gradle, ...)

// Maven(20명이 다 동시에 다운받기 -> DDos)
// 처음부터 Maven project로 생성 / 자바프로젝트면 프로젝트 우클릭 -> configure -> Convert to maven project
// Group : 회사명 / Artifact Id : 프로그램명
// 1) .jar수동관리 -> Maven으로 관리하게 바꾸기 -> pom.xml 만들어짐
// 2) 쓰고싶은 라이브러리의 Maven 소스 구해서 mvnrepository.com or 알아서 잘..
// 3) pom.xml을 수정
//		<dependencies>
//			2)을 여기에 복붙
//		</dependencies>
//		-> 메이븐 중앙저장소에서 자동으로 .jar 받아옴
//			PC의 로컬저장소에 저장
//			C:\사용자\계정\.m2\repository
//			프로젝트에서 쓸수있게 세팅까지 해줌
public class MMain {
	public static void main(String[] args) {
		XmlPullParser xpp;
		JSONParser jp;
	}
}

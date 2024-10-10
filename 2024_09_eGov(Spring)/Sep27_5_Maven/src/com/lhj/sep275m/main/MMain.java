package com.lhj.sep275m.main;

import org.xmlpull.v1.XmlPullParser;

import hojun.lee.db.manager.LeeDBManger;

// 웹 개발자 -> 웹 개발
// 앱 개발자 -> 앱 개발
// -> 늘 쓰던 라이브러리 씀
// -> 저번 프로젝트에서 Maven시스템써서 kxml받아와서 로컬저장소에 저장함
//		-> 한번이라도 쓴적있는거 추가하려면 dependencies가서 add후에 검색해서 넣기 : 오 쩐다
//		-> 창열기 (window -> show view -> other -> maven repositories)
// 실전은? 왜함 ㅋㅋ 근데 해도됨 ㅇㅇ

// 메이븐 중앙저장소에 없는거 쓰고싶다면
//	-> 자체 제작한거
//		메이븐으로 자동관리 + 수동관리 병행 불가
//		자체 제작한거를 메이븐시스템에 넣어서 사용
//		-> package explorer -> 빈자리에 import -> 3번째꺼
//		-> 한 다음 pom.xml에 직접 작성하던지 아니면 검색해서 쓰던지
//		ojdbc는 없음 -> 따로 다운받아서 메이븐시스템에 넣어서 쓰기 
//						or 사설저장소 등록(dependencies 위에 repository 넣고 dependencies 추가)

// Java : 압도적
// Oracle, MySQL... 왜 우리가 Oracle을썼을까 : 압도적으로 많이 씀
// Java + Oracle = ??

public class MMain {
	public static void main(String[] args) {
		XmlPullParser xpp;
		LeeDBManger.close(null, null, null);
		
	}
}

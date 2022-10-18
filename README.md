# JSP_workSpace-notes

## JQuery 라이브러리 
 
[ JQuery 사용법 : https://api.jquery.com ]
 
API Documentation >>  .add() >>  [아래 JQuery 코드 붙여넣기]
 
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
 
=================================================================
 
# JQuery 기본 문법
 
모든 객체는 $(내장객체) 혹은 $("선택자")를 이용해 호출한다 ( $ 대신에 jQuery를 써도 된다 )
 
$(document).ready( ); <<  엔터링 포인트
$(document) 내장객체 . ready(); 메서드
 
 
# jQuery를 통해서 원하는 element를 가져오는 3가지 방법
 
1 element의 태그명을 이용해서 호출하는 방법       예) $("div")
2 css class 속성을 이용하는 방법        예) $(".class1")
3 id 속성을 이용하는 방법         예) $("#id1")
 
 
# jQuery를 통해서 원하는 메서드를 사용하는방법 - 호출한 jQuery객체 + [. jQuery 메서드 ();]
 
$("[태그명], [#iD 값], [.class 값]"). jQuery의 메서드()
 
# callback 함수 - 매개변수 자리에 위치한 이름이 없는 함수 ( 호출되면 바로 실행되는 특징을 가진다 ) 
=================================================================
 
[예제문제1] jquery 사용 해보기
( jquery를 활용해서 "jquery 시작하기" 경고창을 출력하는 코드를 작성해보자 )
 
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script> 
    // jquery를 사용할 수 있도록 [스크립트 태그로 주소값을 호출]
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
<body> 
</body>
</html>
 
jquery.js
=========
$(document).ready( 
            function(){
                alert("jQuery 시작하기");
            }
            );
 
// Java에서 엔터링 포인트(= 메인 메서드) 코드가 호출되면 내부에 함수를 바로 실행한다. 
// Java Script에서 window.onload=function(){} 코드가 호출되면 내부에 함수를 바로 실행한다. 
// jquery $(document).ready( function(){} ); 드가 호출되면 내부에 함수를 바로 실행한다. 
 
-----------------------------------------------------------------------------
 
[예제문제2] jquery 객체 내부의 문자열 값 변경 메서드 사용 해보기
 
.html() & .text()- 매개변수가 없을 때 기존 객체의 [문자열 값을 호출]  [ 반환형 : String ]
.html("바꿔줘") & .text("바꿔줘") - 매개변수가 있을 때 입력된 문자로 객체의 [문자열 값을 변경]  [ 반환형 : jquery 객체 ]
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
<body>
    <div id="obj1">AAA</div>
    <div class="obj2">BBB</div>
    <span>CCC</span>
</body>
</html>
    
    
jquery.js
=========
    
$(document).ready(function(){
    $("#obj1").html("<i>차은우</i>"); // id값을 이용해서 jQuery 객체를 호출 >> .html() 메서드로 태그 내부의 문자값을 변경
    alert($("#obj1").text());  // id값을 이용해서 jQuery 객체를 호출
    alert($(".obj2").text());  // class값을 이용해서 jQuery 객체를 호출
    alert($("span").text());   // 태그이름을 이용해서 jQuery 객체를 호출
});    
    
//     .html(); 문자열 내부에 [태그가 있으면 태그로 생각하고 적용함]
//  .text(); 문자열 내부에 [태그가 있으면 문자열로 생각함]
 
    
-----------------------------------------------------------------------------    
    
[예제문제3] jquery 객체 꾸미기 메서드 사용 해보기
 
.css() - 매개변수값을 이용해 css 속성값을 변경     [ 반환형 : jquery 객체 ]
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
    <div>aaa</div>
    <div>bbb</div>
    <div>ccc</div>
</body>
</html>
 
    
jquery.js
=========
        
$(document).ready(function(){
            $($("div")[1]).css( // 2번째 div 태그에 접근하기 위해서는 배열처럼 인덱스 값을 추가 해주는데 $($("선택자")[인덱스])로 다시 묶어야 jquery 객체로 사용할 수 있다
            "backgroundColor","orange" // 매개변수 값을 ("속성", "값")으로 사용함 
            );
            // $("div")[1].style.backgroundColor="orange"; // jquery 객체와 스크립트 코드를 같이 사용할 수 있지만 권장하지는 않는다
            });    
    
    
-----------------------------------------------------------------------------    
    
[예제문제4] jquery 클릭 이벤트 메서드 사용 해보기
( 3번 문제의 "bbb"를 "차은우"로 변경하고 클릭하면 배경색이 pink가 되도록 코드를 작성해보자 )
 
.click() - 클릭 이벤트 처리 ( 매개변수로 callback 함수를 가진다 )     [ 반환형 : jquery 객체 ]
$(this) - jquery에서는 자기 자신의 주소값 또한 $(this)로 묶어서 사용해야 한다 (주의)
    
jquery.js
=========
 
$(document).ready(function(){
        $($("div")[1]).css({
        "backgroundColor":"orange",
        "border":"1px solid navy"
        }).text("차은우").click(f) // 반환형이 jquery 객체인 경우 연속해서 메서드를 사용할 수 있다 [ 메서드 체이닝 ]
    });
function f(){
    $(this).css("backgroundColor","pink")
}
    
    
-----------------------------------------------------------------------------
    
[예제문제5] jquery 폼 태그에 속한 태그들의 value 값을 변경하는 메서드 사용 해보기
 
.val() - 매개변수가 없을 때 기존 객체의 [문자열 값을 호출]  [ 반환형 : String, Array<String> ]
.val("바꿔줘") - 매개변수가 있을 때 입력된 문자로 객체의 [문자열 값을 변경]  [ 반환형 : jquery 객체 ]
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
    <form>
        <input type="text" value="홍길동">
        <button type="button">버튼</button>
    </form>
</body>
</html>
 
 
jquery.js
=========
 
$(document).ready(function(){
    $("button").click(f)
});
function f(){
    $("input:text").val("차은우") ;
}
 
 
-----------------------------------------------------------------------------
 
[예제문제6] jquery 폼 태그에 속한 태그들의 value 값을 변경하는 메서드 사용 해보기
( val() 메서드를 활용해서 간단한 계산기 코드를 작성해보자 )
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
    <form>
        <input type="text" id="t1" size="3">+
        <input type="text" id="t2" size="3">
        <button type="button">=</button>
        <input type="text" id="t3" size="3" disabled>
    </form>
</body>
</html>
 
 
jquery.js
=========
 
$(document).ready(function(){
    $(":button").click(f);
});
function f(){
    let n1=parseInt($("#t1").val()); // parseInt() 문자열을 숫자로 변경
    let n2=Number($("#t2").val());    // Number() 문자열을 숫자로 변경
    $("#t3").val(n1+n2);
}
 
 
-----------------------------------------------------------------------------
 
[예제문제7] jquery 마우스 이동(hover) 이벤트 메서드 사용 해보기
 
.hover(마우스 오버 함수, 마우스 아웃 함수) - 마우스의 위치에 따라 [callback 함수]가 다르게 작동하는 메서드  [ 반환형 : jquery 객체 ]
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
    <button type="button">버튼</button>
</body>
</html>
 
 
jquery.js
=========
 
$(document).ready(function(){
    $("button").hover(function(){
        $(this).css("background", "orange")} ,  // 마우스 오버 함수  
        function(){$(this).css("background", "")} // 마우스 아웃 함수  
    )
});
 
 
-----------------------------------------------------------------------------
 
[예제문제8] jquery 반복 호출 메서드 사용 해보기 [ 다른 언어의 반복문과 비슷한 역할을 수행 ]
 
.each(function(인텍스, jquery 객체){ }) - 대상 [jquery 객체]를 순서에 따라 모두 호출하는 메서드 내부에 [callback 함수]를 실행 [ 반환형 : jquery 객체 ]
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
    <button type="button">aa</button>
    <button type="button">bb</button>
    <button type="button">cc</button>
</body>
</html>
 
 
jquery.js
=========
 
$(document).ready(function(){
    const array=["orange","pink","tomato"];
    $("button").each(function(index){$(this).css("background",array[index]) } )
    });
 
 
-----------------------------------------------------------------------------
 
[예제문제9] jquery 입력 받은 위치에 해당하는 [jquery 객체]를 반환하는 메서드 사용 해보기
 
.eq(인덱스값) - 여러개의 [jquery 객체]들중 인덱스 위치에 해당하는 [jquery 객체]를 반환한다  [ 반환형 : jquery 객체 ]
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
    <input type="text">
    <input type="text">
</body>
</html>
 
 
jquery.js
=========
 
$(document).ready(function(){
    $($("input:text")[0]).css("background","pink"); // 앞서 배운 배열과 유사한 방법으로 호출하는 방법
    $("input:text").eq(1).css("background","midnightblue"); // eq() 메서드를 이용해서 호출하는 방법
});
 
 
-----------------------------------------------------------------------------
 
[예제문제10] jquery의 메서드를 오버라이딩 해서 사용 해보기
 
.fn.extend() - jQuery의 내장 메서드의 기능을 변경한다 [ 반환형 : jquery 객체 ]
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
    <input type="text">
</body>
</html>
 
 
jquery.js
=========
 
$(document).ready(function(){
    $.fn.extend({
    eq:function(){ return "차은우"; } 
    // 기존의 eq(인덱스) 메서드는 인덱스 위치에 해당하는 객체를 반환하는 메서드 >> 여기서는 "차은우"를 반환하는 메서드로 오버라이딩 
    });
    alert($(":text").eq());
    });
 
 
-----------------------------------------------------------------------------
 
[예제문제11] jquery에서 사용자가 정의한 메서드를 추가해서 사용 해보기
 
.extend(Object) - jQuery에 사용자가 정의한 메서드를 추가 [ 반환형 : Object ]
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
    <input type="text">
</body>
</html>
 
 
jquery.js
=========
 
$(document).ready(function(){
    $.extend({
    aabbcc:function(){ return "차은우";} // 자료형이 Object이기 때문에 객체형태로 선언
    });
    alert($.aabbcc()); // 호출하는 방법
    });
 
 
-----------------------------------------------------------------------------
 
[예제문제12] jquery에서 [폼 태그에 속한 태그들]의 속성 값을 이용해 [jquery 객체]에 접근해보기
 
$("input:checkbox") < 체크 박스 객체에 접근 ( input은 생략가능 )
$("input:checkbox:checked") < 체크된 체크 박스 객체에 접근 ( input은 생략가능 )
$("input:checkbox:not(:checked)") < 체크되지 않은 체크 박스 객체에 접근 ( input은 생략가능 )
[ 주의할 부분 :not의 경우에 :not(:속성)으로 묶어줘야만 사용가능 ]
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
    <input type="checkbox" checked value="aa">aa
    <input type="checkbox" value="bb">bb
    <input type="checkbox" checked value="cc">cc
    <input type="checkbox" value="dd">dd
</body>
</html>
 
 
jquery.js [ 체크박스에서 선택된 값을 모아서 출력 ]
=========
 
$(document).ready(function(){
    let str="";
    $(":checkbox:checked").each(function(i){
    str+=$(this).val()+",";
    });
    alert(str);
    });
    
jquery.js [ 체크박스에서 선택되지 않은 값을 모아서 출력 ]
=========
 
$(document).ready(function(){
    let str="";
    $(":checkbox:not(:checked)").each(function(i){ // :not(:checked)와 같이 괄호로 묶어서 사용한다
    str+=$(this).val()+",";
    });
    alert(str);
    });
 
 
-----------------------------------------------------------------------------
 
[예제문제13] jquery에서 [폼 태그에 속한 태그들]의 속성 값을 이용해 [jquery 객체]에 접근해보기
( 라디오 버튼중 체크 되지 않은 버튼의 vlaue 값을 출력하는 코드를 작성해보자 )
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
    <input type="checkbox" checked value="aa">aa
    <input type="checkbox" value="bb">bb
    <input type="checkbox" checked value="cc">cc
    <input type="checkbox" value="dd">dd
    <input type="radio" checked name="box" value="ee">ee
    <input type="radio" name="box" value="ff">ff
</body>
</html>
 
 
jquery.js 
=========
 
$(document).ready(function(){
    let str="";
    $("input:radio:not(:checked)").each(function(i){
    str+=$(this).val()+",";
    });
    alert(str);
    });
    
    
==========================================================================
[알아두면 쓸만한 메서드]
size() & length - 일치하는 객체의 개수를 리턴한다 [ 반환형 : number ]
get() - 대상이 되는 모든 객체들을 리턴한다  [ 반환형 : Array<Element> ] 매개변수로 인덱스를 주면 해당 인덱스의 객체를 리턴한다
 
 
## 선택자  
1. $("선택자, 선택자2, 선택자3,....") - 선택자 다수를 한번에 선택 가능하다
2. $("부모선택자  자식선택자") - 부모객체의 자식객체들을 반환    [ 반환형 : Array<Element> ] 
3. $("부모선택자 > 자식선택자") - 부모객체의 [직계 자식객체(=인접한 노드)]중 자식 선택자인 객체들을 반환    [ 반환형 : Array<Element> ] 
4. $("기준선택자 + 대상선택자") - 기준선택자를 기준으로 [같은 노드 레벨의 인접한 대상] 즉 바로 다음에 등장하는 선택자 객체 반환    [ 반환형 : Array<Element> ] 
5. $("기준선택자 ~ 대상선택자") - 기준선택자를 기준으로 [같은 노드 레벨]의 대상 선택자 객체들을 반환    [ 반환형 : Array<Element> ] 
6. $("선택자 : fisrt") - 첫번째 선택자 객체
7. $("선택자 : last") -  마지막 선택자 객체    
8. $("선택자1 : not (선택자2)") - 선택자1중 선택자2가 아닌 객체
   
    예) $("<div> + <p>") & $("<div> ~ <p>")라고 한다면 결과값은 없다 [ 기준점 아래로만 찾는다..... ]
    
        <p> jquery </p>
        <div>
            <span> hi! </span>
        </div>
        <b> java </b>
        <a href="#">
 
==========================================================================
 
[예제문제14] jquery에서 객체의 속성값을 제거하는 메서드 사용 해보기
( 옵션을 선택하고 버튼을 눌렀을 때 선택 속성이 취소되는 코드를 작성해보자 )
 
.removeAttr("속성") - 객체의 속성값을 제거하는 메서드 [ 반환형 : jquery 객체 ]
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="jquery.js"></script>  // 스크립트 파일 연결
</head>
<select size="3">
        <option>aa</option>
        <option>bb</option>
        <option>cc</option>
        </select>
        <button type="button">선택해제</button>
</body>
</html>
 
 
jquery.js 
=========
 
$(document).ready(function(){
    $("button").click(f);
    });
    function f(){
        $("option").removeAttr("selected");
    };
![image](https://user-images.githubusercontent.com/48202197/196463033-2fd10576-3ad6-41e8-a67c-9e34b78fcb38.png)


## json 데이터 전송 방법
 
http://json-lib.sourceforge.net/apidocs/jdk15/index.html
 
 
#API & 사전 확인 사항
 
public interface MemberDAO { // 인터페이스 MemberDAO
public class MemberDAOImpl implements MemberDAO {} // 클래스 MemberDAOImpl [인터페이스 MemberDAO]를 구현하고 있음
 
public interface JsonObject extends JsonStructure, Map<String,JsonValue> // 인터페이스 JsonObject 
// [ map<String, JsonValue>]을 상속받고 있음 
 
http://json-lib.sourceforge.net/apidocs/jdk15/index.html
 
net.sf.json.JSONObject 패키지 
>> public final class JSONObject [extends Object] [implements JSON, Map, Comparable] // JSONObject 클래스
   [Object 클래스]를 상속 받고 있고 [JSON, Map, Comparable 인터페이스]를 구현하고 있음 
    >> public static JSONObject fromObject(Object object)   // 메서드  [반환형이 : JSONObject] Object (일반적으로 문자열)을 넣어주면 JSONObject 객체로 변환시켜 반환
    >> public JSONArray getJSONArray(String key)       // 메서드 [반환형이 : JSONArray] value 값이 배열 형태면 사용
    >> public JSONObject getJSONObject(String key)  // 메서드 [반환형이 : JSONObject] value 값이 유사배열객체 형태면 사용
 
==========================================================================================================
==========================================================================================================
 
[예제문제1] DB연동을 통해 전달받은 데이터를 JSONObject의 메서드를 이용해서 [JSONObject 타입: array like ]으로 변경해보자 
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>  // import 콜렉션 
<%@page import="net.sf.json.JSONObject"%> // import 콜렉션 JSONObject
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
 
 
<%
    MemberDAO dao=MemberDAOImpl.getInstance(); 
    // MemberDAOImpl의 객체의 주소값은 getInstance() 메서드를 호출해서 변수에 저장해서 사용 [ 싱글톤 패턴 ]
    List<MemberBean> list=dao.selectMemberList(); 
    // DB연동 dao.selectMemberList()를 호출해서 [쿼리문 :"select * from member" ]의 결과 값을 List<MemberBean> 형태로 돌려받음 
    Map<String,Object> map=new HashMap<String,Object>();
    // Map<String,Object> 형태의 Map을 생성 [ JSONObject는 MAP을 구현하고 있으므로 map 형식의 자료는 JSONObject 객체의 생성이 가능하다 ]
    map.put("memberlist",list);
    // JSONObject 객체의 fromObject(map) 메서드를 호출해서 JSONObject 자료형의 객체 생성 확인
    out.print(JSONObject.fromObject(map));
%>
 
[출력값]
 
{"memberlist":
   [{"addr":"addr1","id":"id1","pw":"pw1","rownum":"0","status":"normal","tel":"tel1"},
    {"addr":"addr2","id":"id2","pw":"pw2","rownum":"1","status":"normal","tel":"tel2"},
    {"addr":"addr3","id":"id3","pw":"pw3","rownum":"2","status":"normal","tel":"tel3"},
    {"addr":"addr4","id":"id4","pw":"pw4","rownum":"3","status":"normal","tel":"tel4"},
    {"addr":"addr5","id":"id5","pw":"pw5","rownum":"4","status":"normal","tel":"tel5"},
    {"addr":"addr6","id":"id6","pw":"pw6","rownum":"5","status":"normal","tel":"tel6"} ]
} 
 
 
------------------------------------------------------------------------------------------------
 
[예제문제2] Java Script에서 불러온 JSONObject 객체를 출력해보자 
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>  // import 콜렉션 
<%@page import="net.sf.json.JSONObject"%> // import JSONObject
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
 
 
<%
    MemberDAO dao=MemberDAOImpl.getInstance();
    List<MemberBean> list=dao.selectMemberList();
    Map<String,Object> map=new HashMap<String,Object>();
    map.put("memberlist",list);
    JSONObject obj=JSONObject.fromObject(map);
%>
 
<script>
    let str='<%=obj%>';
    document.write(typeof str+"</br>"); // String 문자열
    document.write(str+"</br>"); // String 문자열
</script>
 
 
------------------------------------------------------------------------------------------------
 
[예제문제3] Java Script에서 불러온 JSONObject 객체를 출력해보자 [ 출력문에서 외따옴표를 지우고 출력해보자 ]
( id pw addr tel을 출력하는 코드를 작성해보자 ) 
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>  // import 콜렉션 
<%@page import="net.sf.json.JSONObject"%> // import JSONObject
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
 
 
<%
    MemberDAO dao=MemberDAOImpl.getInstance();
    List<MemberBean> list=dao.selectMemberList();
    Map<String,Object> map=new HashMap<String,Object>();
    map.put("memberlist",list);
    JSONObject obj=JSONObject.fromObject(map);
%>
 
<script>
    var str=<%=obj%>;
    document.write(typeof str+"</br>"); // Object
    document.write(str.memberlist[0].id+"</br>");
    document.write(str.memberlist[0].pw+"</br>");
    document.write(str.memberlist[0].addr+"</br>");
    document.write(str.memberlist[0].tel+"</br>");
</script>
 
 
------------------------------------------------------------------------------------------------
 
[예제문제4] Java Script의 forEach()메서드를 이용해서 id값들을 모두 출력하는 코드를 작성해보자
( for in 반복문을 이용해서 코드를 수정해 보자 )
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>  // import 콜렉션 
<%@page import="net.sf.json.JSONObject"%> // import JSONObject
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
 
 
<%
    MemberDAO dao=MemberDAOImpl.getInstance();
    List<MemberBean> list=dao.selectMemberList();
    Map<String,Object> map=new HashMap<String,Object>();
    map.put("memberlist",list);
    JSONObject obj=JSONObject.fromObject(map);
%>
 
<script>
    var obj=<%=obj%>;
    obj.memberlist.forEach(function(member){
    document.write(member.id+"<br/>");
    });
</script>
 
 
for in 반복문 이용
==============
 
<script>
    var obj=<%=obj%>;
    for ( index in obj.memberlist){
        document.write(obj.memberlist[index].id+"</br>");
    }
</script>
 
 
------------------------------------------------------------------------------------------------
 
[예제문제5] 쿼리스트링으로 아이디 값이 전달될 때 DB연동하여 결과값을 모두 출력하는 코드를 작성해보자
( http://localhost:8282/ajaxTest/test.jsp?id=id1 << url로 접근 )
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>  // import 콜렉션 
<%@page import="net.sf.json.JSONObject"%> // import JSONObject
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
 
 
<%
    String id=request.getParameter("id"); // 쿼리스트링 값을 이용해 DB연동 값을 받아오는 방법
    MemberDAO dao=MemberDAOImpl.getInstance();
    MemberBean bean=dao.selectMember(id); // [쿼리문 :"select * from member where id=?" ]의 결과 값을 MemberBean 형태로 돌려받음
    Map<String,Object> map=new HashMap<String,Object>();
    map.put("member",bean);
    JSONObject obj=JSONObject.fromObject(map);
%>
 
<script>
    let arrayLike=<%=obj%>;
    document.write(arrayLike.member.id+"</br>");
    document.write(arrayLike.member.pw+"</br>");
    document.write(arrayLike.member.addr+"</br>");
    document.write(arrayLike.member.tel+"</br>");
</script>
 
 
------------------------------------------------------------------------------------------------
 
[예제문제6] 쿼리스트링으로 아이디 값이 전달될 때 DB연동하여 결과값을 모두 택스트 박스에 출력하는 코드를 작성해보자
( http://localhost:8282/ajaxTest/test.jsp?id=id1 << url로 접근 )
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>  // import 콜렉션 
<%@page import="net.sf.json.JSONObject"%> // import JSONObject
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
 
<%
    String id=request.getParameter("id");
    MemberDAO dao=MemberDAOImpl.getInstance();
    MemberBean bean=dao.selectMember(id);
    Map<String,Object> map=new HashMap<String,Object>();
    map.put("member",bean);
    JSONObject obj=JSONObject.fromObject(map);
%>
 
<script>
    window.onload=function(){  // 코드를 모두 읽을 후에 실행 
        const obj=<%=obj%>; // 유사배열로 데이터를 전달  
        let txt1=document.querySelector("#txt1"); // id 값으로 호출해서 변수에 저장 
        let txt2=document.querySelector("#txt2");
        let txt3=document.querySelector("#txt3");
        let txt4=document.querySelector("#txt4");
 
        txt1.value=obj.member.id; // 변수에 유사배열의 값을 초기화
        txt2.value=obj.member.pw;
        txt3.value=obj.member.addr;
        txt4.value=obj.member.tel;
    }
</script>
 
Id : <input type="text" id="txt1"><br/>
Pw :<input type="text" id="txt2"><br/>
Addr : <input type="text" id="txt3"><br/>
Tel :<input type="text" id="txt4"><br/>
 
 
------------------------------------------------------------------------------------------------
 
[예제문제7] 위에서 작성한 코드를 jQuery를 이용해서 수정해보자
( http://localhost:8282/ajaxTest/test.jsp?id=id1 << url로 접근 )
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>  // import 콜렉션 
<%@page import="net.sf.json.JSONObject"%> // import JSONObject
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
 
<%
String id=request.getParameter("id");
MemberDAO dao=MemberDAOImpl.getInstance();
MemberBean bean=dao.selectMember(id);
Map<String,Object> map=new HashMap<String,Object>();
map.put("member",bean);
JSONObject obj=JSONObject.fromObject(map);
%> 
 
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
 
<script>
    $(document).ready(function(){
    const obj=<%=obj%>;
    $("#txt1").val(obj.member.id);
    $("#txt2").val(obj.member.pw);
    $("#txt3").val(obj.member.addr);
    $("#txt4").val(obj.member.tel);
    });
</script>
 
Id : <input type="text" id="txt1"><br/>
Pw :<input type="text" id="txt2"><br/>
Addr : <input type="text" id="txt3"><br/>
Tel :<input type="text" id="txt4"><br/>
 
 
------------------------------------------------------------------------------------------------
 
# API ( Java Script의 내장객체 JSON )
>> JSON.parse() - [스크립트 내장 객체 !!] 문자열을 유사배열객체로 변환 
>> JSON.stringify () - [스크립트 내장 객체 !!] 유사배열객체를 문자열로 변환 
 
================================================================================================
 
[예제문제8] Java Script의 내장객체 JSON의 메서드를 활용해서 유사 배열 객체를 문자열로 변환해 보자
( JSON.stringify(유사배열객체) 메서드 [반환형 : 문자열] 유사배열객체를 문자열로 변경해주는 메서드 ) 
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.7.js">
</script>
<script>
$(document).ready(function(){
    $("#submit1").click(submitFunc1);
});
function submitFunc1(){
    let str={"aa":"bb","cc":"dd"};
    let s=JSON.stringify(str);   // 유사 배열 객체를 문자열로 저장
    let ss=encodeURIComponent(s);  // 문자열을 encoding ( 특수문자나 한글을 온전하게 전달하기위해 암호화 하는 과정 )
    location.href="tt4.jsp?member="+ss; // 페이지 이동 (쿼리스트링 값 포함)
}
</script>
</head>
<body>
<input type="button" value="보내기" id="submit1">
</body>
</html>
 
 
tt4.jsp
=======
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="net.sf.json.JSONObject"%>
 
<%
    String member=request.getParameter("member");
    JSONObject obj=JSONObject.fromObject(member); // [반환형 : JSONObject]  object(여기선 문자열)를 JSONObject로 변환 
    out.print(obj.get("aa")+"</br>");
    out.print(obj.get("cc")+"</br>");
%>
 
 
------------------------------------------------------------------------------------------------
 
[예제문제9] Java Script의 내장객체 JSON의 메서드를 활용해서 유사 배열 객체를 중복으로 사용하고 있는 객체를 문자열로 변환해 보자 
( JSON.stringify(유사배열객체) 메서드 [반환형 : 문자열] 유사배열객체를 문자열로 변경해주는 메서드 ) 
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.7.js">
</script>
<script>
$(document).ready(function(){
    $("#submit1").click(submitFunc);
    });
    function submitFunc(){
    var str={"a":[{"k1":"v1"},{"k2":"v2"}], 
    "b":{"k3":"v3"}};
    var s=JSON.stringify(str);  // 유사 배열 객체를 문자열로 저장
    var ss=encodeURIComponent(s);   // 문자열을 encoding ( 특수문자나 한글을 온전하게 전달하기위해 암호화 하는 과정 )
    location.href="tt6.jsp?data="+ss;  // 페이지 이동 (쿼리스트링 값 포함)
    }
</script>
</head>
<body>
<input type="button" value="보내기" id="submit1">
</body>
</html>
 
 
tt6.jsp
=======
<%@page import="net.sf.json.JSONArray"%>  // JSONArray 값을 다루는 패키지
<%@page import="net.sf.json.JSONObject"%>  // JSONObject 값을 다루는 패키지
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String member=request.getParameter("data");
    JSONObject obj1=JSONObject.fromObject(member);  //  [반환형 : JSONObject]  object(여기선 문자열)를 JSONObject로 변환 
    JSONObject obj2=obj1.getJSONObject("b");      // JSONObject의  b : value 값이 유사배열객체 
    JSONArray array=obj1.getJSONArray("a");        // JSONObject의  a : value 값이 배열 
    JSONObject obj3=array.getJSONObject(0);     // getJSONObject() 메서드를 사용 [반환형 : JSONObject]
    JSONObject obj4=(JSONObject)array.get(1);   // get() 메서드를 사용 [반환형 : Object(형변환필요)]
 
    out.print(obj3.get("k1")+"</br>");
    out.print(obj4.get("k2")+"</br>");
    out.print(obj2.get("k3")+"</br>");
%>
 
=====================================================================================================
 
# 김원장님 코드 
 
<%
    String s=request.getParameter("data");
    JSONObject obj1=JSONObject.fromObject(s);
    JSONArray array=obj1.getJSONArray("a");
    JSONObject obj2=obj1.getJSONObject("b");
 
    JSONObject obj3=array.getJSONObject(0);
    JSONObject obj4=array.getJSONObject(1);
 
    String s1=(String)obj3.get("k1");
    String s2=(String)obj4.get("k2");
    String s3=(String)obj2.get("k3");
%>
<%=s1%><br/>
<%=s2%><br/>
<%=s3%><br/>
 
 
------------------------------------------------------------------------------------------------
 
[예제문제10] jQuery의 ajax() 메서드를 사용해서 페이지를 이동하지 않고 DB연동하여 결과값을 출력해보자 
( $.ajax({ 속성: "값", 속성: "값", .....}) - 속성과 값을 이용해서 데이터  ) 
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.7.js">
</script>
<script>
$(document).ready(function(){
    $("#buttonObj").click(clickFunc);
    });
 
    function clickFunc(){
        $.ajax({
        "url":"tt8.jsp", // 페이지를 이동하지 않고 데이터만 받아올 페이지 
        "data":{"id":$("#id").val()}, // 쿼리스트링 값을 data 속성으로 정의
        "dataType":"json",  // dataType 속성: 연결된 페이지의 출력값을 JSONObject 값으로 받아옴
        "success":function(str){ // 출력 값을 매개변수값으로 받아서옴 [ JSONObject ]
            console.log(str.member.id);
            console.log(str.member.pw);
            console.log(str.member.addr);
            console.log(str.member.tel);
        }
    });
}
</script>
</head>
<body>
    회원ID : <input type="text" id="id">
    <button id="buttonObj">비번얻기</button>
</body>
</html>
 
 
tt8.jsp
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%> 
<%
String id=request.getParameter("id");
MemberDAO dao=MemberDAOImpl.getInstance();
MemberBean bean=dao.selectMember(id);
Map<String,Object> map=new HashMap<String,Object>();
map.put("member",bean);
JSONObject obj=JSONObject.fromObject(map);
out.print(obj); // 출력 값이 있어야 함 
%>
 
================================================================================
 

![image](https://user-images.githubusercontent.com/48202197/196462979-27518d0b-3f40-4d2a-9023-878174b86963.png)


==========================================================================================================
# API ( json-lib ) - http://json-lib.sourceforge.net/apidocs/jdk15/index.html

>net.sf.json.JSONObject 패키지
	>>public final class JSONObject extends Object implements JSON, Map, Comparable 클래스 
		>>> public static JSONObject fromObject(Object object) 메서드 [ 반환형 : JSONObject ] 
		[ 매개변수로 object 자료형이 들어가면 JSONObject 자료형으로 변환해서 반환한다 ]
		>>> public JSONArray getJSONArray(String key) 메서드 [ 반환형 : JSONArray ]
		[ JSONObject 객체. getJSONArray( " 키 값 " )으로 사용하고 반환형이 JSONArray 배열 -> JSONObject 객체 내부에 배열이 있을 때 사용 ]
		>>> public JSONObject getJSONObject(String key) 메서드 [ 반환형 : JSONObject ]
		[ JSONObject 객체. getJSONObject( " 키 값 " )으로 사용하고 반환형이 JSONObject 객체 -> JSONObject 객체 내부에 객체가 있을 때 사용
		>>> public static Object toBean(JSONObject jsonObject, Class beanClass) [ 반환형 : Object bean객체 (형변환 필요)]
		[ (형변환할 자료형) JSONObject . toBean ( JSONObject 객체, Bean객체.class) -> JSONObject 객체를 Bean객체로 변환해주는 메서드 ]

==========================================================================================================




[예제문제1] 실행결과가 아래와 같다. ( JSP 코드로 작성하시오  )

{"aa":["bb","cc"],"dd":{"id":"ff","pw":"hh"}}


test1.jsp
=========
<%@page import="java.util.*"%>
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%
//  다음의 결과값을  출력하는 코드를 작성하시오 
//  {"aa":["bb","cc"],"dd":{"id":"ff","pw":"hh"}} 
 %>
		
<% 
MemberBean bean=new MemberBean(); // 1. MemberBean bean 객체를 생성해준다 (id, pw 셋팅 목적)
bean.setId("FF"); bean.setPw("HH"); // 2. set() 메서드로 값을 등록

Map<String,Object>  map= new HashMap<>(); // 3.  HashMap<>을 만들어서 객체를 담을 수 있도록 준비 [변수의 자료형이 Map<>인 이유 범용성]
map.put("aa", new String[]{"bb","cc"}); // 4. 출력값을 확인해서  key 값과 value 값을 셋팅해준다 [ 배열 생성 방법 3번 : new String[] 배열을 생성해서 바로 요소를 넣어줌] 
map.put("dd", bean); // 5. 4번과 동일한 방법으로  key 값과 value 값을 셋팅해준다 [ value 값은 위에서 셋팅해둔 bean 객체]

out.print(map+"</br>"); 	
//위에서 정리한 자료는 순수 java에서 말하는 object >> Map 형태의 자료이다 출력해보면 배열과 bean 객체 값이 [자료형@~~~]로 나오는 것을 확인 할 수 있다
out.print(JSONObject.fromObject(map));  
// 그래서 우리는 [JSONObject 자료형]으로 변환해주는 과정이 필요한데 이때 json 라이브러리의 net.sf.json.JSONObject 객체의 fromObject() 메서드를 사용한다 [반환형 : JSONObject]
%>


==========================================================================================================

[예제문제2] 실행결과가 아래와 같다. ( JSP 코드로 작성하시오 )

{"aa":["bb","cc"],"dd":[{"id":"FF","pw":"HH"},{"id":"II","pw":"JJ"}]} 


test2.jsp
=========
<%@page import="java.util.*"%>
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="net.sf.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//  다음의 결과값을  출력하는 코드를 작성하시오 
//  {"aa":["bb","cc"],"dd":[{"id":"FF","pw":"HH"},{"id":"II","pw":"JJ"}]} 
 %>
		
<% 
MemberBean bean1=new MemberBean();  //  1. MemberBean bean1 객체를 생성해준다 (id, pw 셋팅 목적)
bean1.setId("FF"); bean1.setPw("HH");  // 2. set() 메서드로 값을 등록

MemberBean bean2=new MemberBean(); // 3. MemberBean bean2 객체를 생성해준다 (id, pw 셋팅 목적)
bean2.setId("II"); bean2.setPw("JJ");  // 4. set() 메서드로 값을 등록

MemberBean[] list={bean1, bean2};  // 배열 객체를 만들어서 bean 객체들을 넣어줌

// List<MemberBean> list=new ArrayList<>(); // ArrayList를 생성해서 bean 객체들을 넣어줌 [ 리스트로 만들어서 사용하는 것이 더 일반적이다 ]
// list.add(bean1);list.add(bean2);

Map<String,Object>  map= new HashMap<>(); // 5.  HashMap<>을 만들어서 객체를 담을 수 있도록 준비 [변수의 자료형이 Map<>인 이유 범용성]
map.put("aa", new String[]{"bb","cc"}); // 6. 출력값을 확인해서  key 값과 value 값을 셋팅해준다 [ 배열 생성 방법 3번 : new String[] 배열을 생성해서 바로 요소를 넣어줌] 
map.put("dd", list); // 7. 4번과 동일한 방법으로  key 값과 value 값을 셋팅해준다 [ value 값은 위에서 셋팅해둔 bean객체가 담긴 배열]

out.print(map+"</br>"); 	
//위에서 정리한 자료는 순수 java에서 말하는 object >> Map 형태의 자료이다 출력해보면 배열과 bean 객체 값이 [자료형@~~~]로 나오는 것을 확인 할 수 있다
out.print(JSONObject.fromObject(map));  
// 그래서 우리는 JSONObject 자료형으로 변환해주는 과정이 필요한데 이때  [json 라이브러리의 net.sf.json.JSONObject 객체의 fromObject() 메서드를 사용한다]
%>


==========================================================================================================
==========================================================================================================


[예제문제 3] jquery의 ajax 메서드를 이용해서 페이지를 이동하지 않고 값을 불러오는 코드를 작성해보자 


test3.jsp
=========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>   
<script>
<%
// jquery의 ajax 메서드를 이용해서 페이지를 이동하지 않고 값을 불러오는 코드를 작성해보자
%>
$(document).ready(function(){ // jquery 에서의 엔터링 포인트
	$("#buttonTag").click(call); // 버튼 태그를 id값으로 호출해서 클릭이벤트 부여  > call 함수를 호출하도록 설정
})
	function call(){
		$.ajax({ // jquery 에서 ajax 메서드를 사용
			url:'test2.jsp', // 값을 받아올 페이지 
			success:function(data){ // 값이 성공적으로 전달될 경우 실행될 callback 함수 매게변수로 test2 페이지의 출력 값을 받아온다
				alert(data); // 전달받은 값을 경고 창으로 출력
			}
		});
	}

</script>
</head>
<body>
<button type="button" id="buttonTag">버튼</button>
</body>
</html>


==========================================================================================================
#API ( 자바 스크립트 ) - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON/parse
Standard built-in objects 기본 내장 객체
	> JSON 객체
		>> JSON.parse() - JSON 문자열을 분석하고, 결과로써 JavaScript 객체를 생성합니다  예) {키: 값, 키: 값} 
		>> JSON.stringify() -  JavaScript 객체를 분석하고, 결과로써 JSON 문자열을 변환합니다  예) "{키: 값, 키: 값}"


==========================================================================================================


[예제문제 4] jquery의 ajax 메서드를 이용해서 페이지를 이동하지 않고 값을 불러오는 코드를 작성해보자
( 자바스크립트를 이용해서 전달받은 문자열을 JSON 자료형으로 변환하고 선택해서 출력하는 코드를 작성해보자 ) 


test4.jsp
=========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>  
<script>
<%
// jquery의 ajax 메서드를 이용해서 페이지를 이동하지 않고 값을 불러오는 코드를 작성해보자
// ajax 메서드의 dataType 속성을 이용해서 JSON 자료형의 값을 받아 출력하는 코드를 작성해보자
// 전달 받는 값 - {"aa":["bb","cc"],"dd":[{"id":"FF","pw":"HH"},{"id":"II","pw":"JJ"}]}
%>
$(document).ready(function(){ // jquery 에서의 엔터링 포인트
	$("#buttonTag").click(call); // 버튼 태그를 id값으로 호출해서 클릭이벤트 부여  > call 함수를 호출하도록 설정
})

	function call(){
		$.ajax({ // jquery 에서 ajax 메서드를 사용
			url:'test2.jsp', // 값을 받아올 페이지 
			success:function(data){ // 값이 성공적으로 전달될 경우 실행될 callback 함수 매게변수로 test2 페이지의 출력 값을 받아온다
				let obj=JSON.parse(data); // 스크립트 내장 객체 JSON의 parse() 메서드를 사용해서 전달받은 문자열을 JSON 형태로 변환해주는 메서드
				alert(obj.aa[1]);  // 전달 받은 값의  "aa"를 키값으로 가지는 배열의 두번째 값을 출력해보자 
				alert(obj.dd[0].id); // 전달받은 값의 "dd"를 키값으로 가지는 배열의 첫번째 객체의 id를 키값으로 가지는 값을 출력해보자
				alert(obj.dd[0].pw); // 전달받은 값의 "dd"를 키값으로 가지는 배열의 첫번째 객체의 pw를 키값으로 가지는 값을 출력해보자
			}
		});
	}

</script>
</head>
<body>
<button type="button" id="buttonTag">버튼</button>
</body>
</html>



==========================================================================================================

[예제문제 5] jquery의 ajax 메서드를 이용해서 페이지를 이동하지 않고 값을 불러오는 코드를 작성해보자 [ 4번과 동일한 문제 ]
( ajax 메서드의 dataType 속성을 이용해서 JSON 자료형의 값을 받아 선택해서 출력하는 코드를 작성해보자 ) 


test4.jsp
=========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>  
<script>
<%
// jquery의 ajax 메서드를 이용해서 페이지를 이동하지 않고 값을 불러오는 코드를 작성해보자
// ajax 메서드의 dataType 속성을 이용해서 JSON 자료형의 값을 받아 출력하는 코드를 작성해보자
// 전달 받는 값 - {"aa":["bb","cc"],"dd":[{"id":"FF","pw":"HH"},{"id":"II","pw":"JJ"}]}
%>
$(document).ready(function(){ // jquery 에서의 엔터링 포인트
	$("#buttonTag").click(call); // 버튼 태그를 id값으로 호출해서 클릭이벤트 부여  > call 함수를 호출하도록 설정
})
	function call(){
		$.ajax({ // jquery 에서 ajax 메서드를 사용
			url:'test2.jsp', // 값을 받아올 페이지 
			dataType: 'json', // 전달받는 값이 문자열 값이아니라 JSONObject 타입으로 변환해서 받아온다
			success:function(data){ // 값이 성공적으로 전달될 경우 실행될 callback 함수 매게변수로 test2 페이지의 출력 값을 받아온다
				alert(data.aa[1]);  // 전달 받은 값의  "aa"를 키값으로 가지는 배열의 두번째 값을 출력해보자 
				alert(data.dd[0].id); // 전달받은 값의 "dd"를 키값으로 가지는 배열의 첫번째 객체의 id를 키값으로 가지는 값을 출력해보자
				alert(data.dd[0].pw); // 전달받은 값의 "dd"를 키값으로 가지는 배열의 첫번째 객체의 pw를 키값으로 가지는 값을 출력해보자
			}
		});
	}

</script>
</head>
<body>
<button type="button" id="buttonTag">버튼</button>
</body>
</html>


==========================================================================================================

[예제문제 6] DB에 연동해서 id값을 모두 불려오는 코드를 작성해보자


test5.jsp
=========
<%@page import="java.util.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%
MemberDAO dao=MemberDAOImpl.getInstance();
List<MemberBean> memberlist=dao.selectMemberList();
Map<String,Object> map=new HashMap<>();
map.put("list",memberlist);
out.print(JSONObject.fromObject(map));
%>



==========================================================================================================

[예제문제 7] jquery 에서의 getJSON() 메서드 이용해서 id값을 리스트로 출력하는 코드를 작성해보자


test6.jsp
=========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"> </script>
<script>
<%
//jquery의 getJSON(); 메서드를 이용해서 페이지를 이동하지 않고 값을 불러오는 코드를 작성해보자
//전달 받는 값 - {"aa":["bb","cc"],"dd":[{"id":"FF","pw":"HH"},{"id":"II","pw":"JJ"}]}
%>

$(document).ready(function(){ // jquery 에서의 엔터링 포인트
	$("#buttonTag").click(callLIst); // 버튼 태그를 id값으로 호출해서 클릭이벤트 부여  > callList 함수를 호출하도록 설정
})
	
function callLIst(){
	$.getJSON( "test5.jsp", function( data ) {  // jquery 에서의 getJSON() 메서드 매개변수로 (url, callback함수(data))
		let items = [];  // id 값을 담아둘 리스트를 생성
		$.each( data.list, function( index, member ) { // jquery 에서의 each() 메서드 매개변수로 (데이터값, callback함수(index, element))  
			items.push( "<li>" + member.id + "</li>" ); // 배열에 추가 <li> id값을 key값으로 가지는 value값을 셋팅 </li> 
		});
	
		$( "<ol/>", { // jquery 에서는 $("<ol/>", {속성:값, 속성:값....} ) 방법으로 태그를 만들 수 있다
			"class": "my-new-list",
			html: items.join( "" ) // html 속성은 자바스크립트의 innerhtml 과 동일하다  // join() 메서드 요소를 붙여서 하나의 문자열로 만들어주는 메서드
		}).appendTo( "body" ); // jquery 에서는 반환형이 jquery인 친구들은 메서드를 연속해서 사용할 수 있다 ( 메서드 체이닝) 
											 //	(자식)appendTo(부모); 자식을 부모에서 상속시키는 메서드  
	});
	}

</script>
</head>
<body>
	<button type="button" id="buttonTag">버튼</button>
</body>
</html>


==========================================================================================================

[예제문제 8] [http://localhost:8282/ajaxTest/test/test7.jsp?id=id1]의 url로 접근했을 때 
다음과 같이 출력되도록 코드를 작성하시오  //  {"member":{"pw":"11","id":"id10"}}


test7.jsp
=========
<%@page import="java.util.*"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<% 
String id= request.getParameter("id");
MemberDAO dao=MemberDAOImpl.getInstance();
MemberBean bean=dao.selectMember(id);
Map<String,Object> map=new HashMap<>();
map.put("member",bean);
out.print(JSONObject.fromObject(map));
%>

==========================================================================================================

[예제문제 9] 아이디 값을 입력하고 버튼을 눌렀을 때 비밀번호가 호출되는 코드를 작성해보자 


test8.jsp
=========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>

$(document).ready(function(){ //  jquery 에서의 엔터링 포인트
	$("#buttonTag").click(getPw); // 버튼 태그를 id값으로 호출해서 클릭이벤트 부여  > getPw 함수를 호출하도록 설정
});

function getPw(){
	$.ajax({  // jquery 에서 ajax 메서드를 사용
		url:'test7.jsp', // 값을 받아올 페이지 ( 한명의 db 연동 값 )
		data:{id: $("#txt").val()},  // 쿼리 스트링 값으로 ?id=택스트박스 입력값을 보내겠다
		dataType:'json',  // 전달받는 값이 문자열 값이아니라 JSONObject 타입으로 변환해서 받아온다
		success: function(data){ // 값을 성공적으로 전달받을 경우 실행될 callback 함수매게변수로 test7 페이지의 출력 값을 받아온다
			$("body").append(data.member.pw); // 전달받은 값을 출력하기 위해서 (부모).append(자식) 메서드를 사용하여 출력하였다
		}
	})
}

</script>
</head>
<body>
	ID : <input type="text" id="txt">
	<button type="button" id="buttonTag">비번얻기</button>
</body>
</html>


==========================================================================================================

[예제문제 10] 회원리스트 버튼을 눌렀을 때 아이디 리스트가 호출되는 코드를 작성해보자 
( 호출된 아이디는 모두 링크 처리를 해주도록 하자 )


test9.jsp
=========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>

$(document).ready(function(){  //  jquery 에서의 엔터링 포인트
	$("#listButton").click(listCall); // 버튼 태그를 id값으로 호출해서 클릭이벤트 부여  > listCall 함수를 호출하도록 설정
})

function listCall(){
	const str=[]; // 만들 리스트를 저장해둘 배열 생성
		$.ajax({  // jquery 에서 ajax 메서드를 사용
			url: 'test5.jsp',  // 값을 받아올 페이지 ( db 연동 값 리스트값 )
			dataType: 'json', // 전달받는 값이 문자열 값이아니라 JSONObject 타입으로 변환해서 받아온다
			success: function(data){   // 값을 성공적으로 전달받을 경우 실행될 callback 함수매게변수로 test5 페이지의 출력 값을 받아온다
				$.each(data.list, function(index, member){ // 	$.each() 메서드 호출 반복적으로 처리 매개변수 : ( 데이터 값, callback 함수 ( 인덱스, 값)) 
					str.push("<li><a href='#'>"+member.id+"</a></li>"); // 각각의 맴버마다  리스트태그와 링크태그 그리고 id 값을 저장해서 배열에 넣어줌
				})
				$('<ol/>', {	 // jquery 에서  태그 만드는 법 $('만들태그이름', '속성:값, 속성,값....')
					'class': 'orderList', // 클래스 이름 부여
					html:str  // 자바스크립트에 innerhtml과 동일한 속성 
				}).appendTo("body"); // 전달받은 값을 리스트로 출력하기 위해서 (자식).appendTo(부모) 메서드를 사용하여 출력하였다
			}
		})
}
</script>
</head>
<body>
	<button type="button" id="listButton">회원리스트</button>
</body>
</html>


==========================================================================================================

[예제문제 11] 회원리스트 버튼을 눌렀을 때 아이디 리스트가 호출되는 코드를 작성해보자 
( 10번 문제 링크에 클릭 이벤트를 추가해서 비밀번호를 호출해서 출력하는 코드를 추가해서 작성해보자 )

test9.jsp
=========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>

$(document).ready(function(){  //  jquery 에서의 엔터링 포인트
	$("#listButton").click(listCall); // 버튼 태그를 id값으로 호출해서 클릭이벤트 부여  > listCall 함수를 호출하도록 설정
})

function listCall(){
	const str=[]; // 만들 리스트를 저장해둘 배열 생성
		$.ajax({  // jquery 에서 ajax 메서드를 사용
			url: 'test5.jsp',  // 값을 받아올 페이지 ( db 연동 값 리스트값 )
			dataType: 'json', // 전달받는 값이 문자열 값이아니라 JSONObject 타입으로 변환해서 받아온다
			success: function(data){   // 값을 성공적으로 전달받을 경우 실행될 callback 함수 매게변수로 test5 페이지의 출력 값을 받아온다
				
				$.each(data.list, function(index, member){ // 	$.each() 메서드 호출 반복적으로 처리 매개변수 : ( 데이터 값, callback 함수 ( 인덱스, 값)) 
					str.push("<li><a href='#'>"+member.id+"</a></li>"); // 각각의 맴버마다  리스트태그와 링크태그 그리고 id 값을 저장해서 배열에 넣어줌
				})
			
				$('<ol/>', {	 // jquery 에서  태그 만드는 법 $('만들태그이름', '속성:값, 속성,값....')
					'class': 'orderList', // 클래스 이름 부여
					html:str  // 자바스크립트에 innerhtml과 동일한 속성 
				}).appendTo("body"); // 전달받은 값을 리스트로 출력하기 위해서 (자식).appendTo(부모) 메서드를 사용하여 출력하였다
			
				$('.orderList a').click(pwGet);
			}
		})
}

function pwGet(){
	const parent=$(this).parent();  //  jquery 에서  parent()메서드 사용 이벤트 발생한 태그의 부모 태그 호출
	$.ajax({
		url:'test7.jsp',
		data:{'id': $(this).text() },
		dataType: 'json', // 전달받는 값이 문자열 값이아니라 JSONObject 타입으로 변환해서 받아온다
		success: function(data){   // 값을 성공적으로 전달받을 경우 실행될 callback 함수 매게변수로 test7 페이지의 출력 값을 받아온다
			parent.append(" "+data.member.pw); // 위에서 정의한 부모 태그에 (부모).append(자식) 메서드를 사용하여 출력하였다 
		}
	})
}


</script>
</head>
<body>
	<button type="button" id="listButton">회원리스트</button>
</body>
</html>


==========================================================================================================

[예제문제 12] 회원리스트 버튼을 눌렀을 때 아이디 리스트가 호출되는 코드를 작성해보자 
( 10번 문제 링크에 클릭 이벤트를 추가해서 비밀번호를 호출해서 출력하는 코드를 추가해서 작성해보자 )


test9-1.jsp [ 김원장님 코드 ]
===========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>

$(document).ready(function(){ //  jquery 에서의 엔터링 포인트
	$("#listButton").click(f); // 버튼 태그를 id값으로 호출해서 클릭이벤트 부여  > f 함수를 호출하도록 설정
});

function f(){
	
	$.getJSON( "test5.jsp", function( data ) { // jquery 에서의 getJSON() 메서드 매개변수로 (url, callback함수(data))
		var items = []; // 만들 리스트를 저장해둘 배열 생성
		
		$.each( data.list, function( index, member ) {  // 	$.each() 메서드 호출 반복적으로 처리 매개변수 : ( 데이터 값, callback 함수 ( 인덱스, 값)) 
			items.push( "<li><a href=#>" + member.id + "</a></li>" ); // 각각의 맴버마다  리스트태그와 링크태그 그리고 id 값을 저장해서 배열에 넣어줌
		});
	
		$( "<ol/>", {  // jquery 에서  태그 만드는 법 $('만들태그이름', '속성:값, 속성,값....')
			"class": "my-new-list",  // 클래스 이름 부여
			html: items.join( "" ) // 자바스크립트에 innerhtml과 동일한 속성  // join()메서드를 이용해서 배열 값들을 모두 문자열로 붙여줌
		}).appendTo( "body" ); // 전달받은 값을 리스트로 출력하기 위해서 (자식).appendTo(부모) 메서드를 사용하여 출력하였다
	
	$(".my-new-list a").click(function(){
		let liTag=this.parentNode; //  jquery 에서  parent()메서드 사용 이벤트 발생한 태그의 부모 태그 호출
			$.ajax({
				url:"test7.jsp",  // 값을 받아올 페이지 ( 한명의 db 연동 값  )
				data:{id:$(this).text()}, 
				dataType:"json", // 전달받는 값이 문자열 값이아니라 JSONObject 타입으로 변환해서 받아온다
				success:function(obj){  // 값을 성공적으로 전달받을 경우 실행될 callback 함수 매게변수로 test7 페이지의 출력 값을 받아온다
					//$("body").append(obj.member.pw);
					//alert(liTag.innerHTML);
					let textNode=document.createTextNode(obj.member.pw); // 자바스크립트 DOM 메서드로 text 태그를 만든다음 값을 넣어줌
					liTag.appendChild(textNode); // 위에서 정의한 부모 태그에 자바스크립트 (부모).appendChild(자식) 메서드를 사용하여 출력하였다 
				},
				error:function(a,b,c){
					alert(a+","+b+","+c);
				}
			});	
		});
	});
}

</script>
</head>
<body>
	<button type="button" id="listButton">회원리스트</button>
</body>
</html>


==========================================================================================================

[예제문제 14] 전송 버튼을 눌렀을 때 테이블 내부의 값을 객체에 value 값에 부여하는 코드를 작성해보자 
[ 결과값 // obj={"id":"aa","pw":"bb","addr":"cc","tel":"dd"} ]

test10.jsp
=========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td { border:1px solid navy; }
</style>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>

$(document).ready(function(){  //  jquery 에서의 엔터링 포인트
	$("#submitButton").click(write); // 버튼 태그를 id값으로 호출해서 클릭이벤트 부여  > write 함수를 호출하도록 설정
});

function write(){
	let obj={"id":"","pw":"","addr":"","tel":""}; // 객체의 key 값에 맞춰 value 값을 채워 넣는것이 목표
	let array=["id","pw","addr","tel"]; // 키 값을 저장하고 있는 배열을 생성
	$("#trTag").children().each(function(index, element ){ 
		//  jquery 에서의 children() 메서드 자식 태그를 배열 형태로 리턴 
		//  each() 메서드 호출 반복적으로 처리 매개변수 : ( 데이터 값, callback 함수 ( 인덱스, 값)) 
		obj[array[index]]=$(element).text(); // index 값을 활용해서 객체의 key 값에 맞는 value 값을 호출해서 재할당
	})
	alert(obj.id+","+obj.pw+","+obj.addr+","+obj.tel); // 출력을 통해 올바로 셋팅이 되었는지 확인
}

</script>
</head>
<body>
	<button type="button" id="submitButton">전송</button>
<table>
	<tr><td>ID</td><td>PW</td><td>ADDR</td><td>TEL</td></tr>
	<tr id="trTag"><td>aa</td><td>bb</td><td>cc</td><td>dd</td></tr>
</table>
</body>
</html>



==========================================================================================================

[예제문제 15] 전송 버튼을 눌렀을 때 테이블 내부의 값을 객체에 value 값에 부여하는 코드를 작성해보자 
[ 넘겨줄 쿼리 스트링 ->  test11.jsp?senddata={"member":{"id":"aa","pw":"bb","addr":"cc","tel":"dd"}} ]

test10.jsp
=========
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td { border:1px solid navy; }
</style>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>

$(document).ready(function(){  //  jquery 에서의 엔터링 포인트
	$("#submitButton").click(write); // 버튼 태그를 id값으로 호출해서 클릭이벤트 부여  > write 함수를 호출하도록 설정
});

function write(){
	let obj={"id":"","pw":"","addr":"","tel":""}; // 객체의 key 값에 맞춰 value 값을 채워 넣는것이 목표
	//let array=["id","pw","addr","tel"]; // 키 값을 저장하고 있는 배열을 생성
	let array=Obj.keys(obj); // 자바스크립트 배열객체의 key() 메서드 호출  키값들을 배열로 리턴
	$("#trTag").children().each(function(index, element ){ 
		//  jquery 에서의 children() 메서드 자식 태그를 배열 형태로 리턴 
		//  each() 메서드 호출 반복적으로 처리 매개변수 : ( 데이터 값, callback 함수 ( 인덱스, 값)) 
		obj[array[index]]=$(element).text(); // index 값을 활용해서 객체의 key 값에 맞는 value 값을 호출해서 재할당
	})
	// alert(obj.id+","+obj.pw+","+obj.addr+","+obj.tel); // 출력을 통해 올바로 셋팅이 되었는지 확인
	let obj2={"member": obj};  // 새로운 객체를 생성해서 위에서 셋팅한 객체를 담음
	let str=JSON.stringify(obj2);  // 자바 스크립트의 내장 객체 JSON의 stringify()를 이용해서 문자열로 변환
	let strEncode=encodeURIComponent(str); // 특수문자나 한글을 올바르게 전달하기 위해 인코딩	
	location.href='test11.jsp?senddata='+strEncode;  // 자바스크립트 페이지 이동 [ location.href='주소값' ]
}

</script>
</head>
<body>
	<button type="button" id="submitButton">전송</button>
<table>
	<tr><td>ID</td><td>PW</td><td>ADDR</td><td>TEL</td></tr>
	<tr id="trTag"><td>aa</td><td>bb</td><td>cc</td><td>dd</td></tr>
</table>
</body>
</html>




test11.jsp
=========
<%@page import="net.sf.json.JSONObject"%>
<%@page import="net.sf.json.JSON"%>
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
// 넘어오는 쿼리 스트링 ->  test11.jsp?senddata={"member":{"id":"aa","pw":"bb","addr":"cc","tel":"dd"}}
String s=request.getParameter("senddata"); // 쿼리스트링에서 값을 받아서 저장 ( 문자열)
JSONObject obj1=JSONObject.fromObject(s); // JSONObject 객체의 fromObject() 메서드를 통해 [문자열을 JSONObject 객체]로 변환
JSONObject obj2=obj1.getJSONObject("member"); // 우리가 필요한 정보는 객체 내부에 있는 객체에 있으니까 getJSONObject("키값") 메서드로 내부 객체로 접근
MemberBean bean=(MemberBean)JSONObject.toBean(obj2,MemberBean.class); // JSONObject 객체 toBean() 메서드를 이용해서 bean 객체로 변환
%>

<%=bean.getId()%> 
<%=bean.getPw()%>


![image](https://user-images.githubusercontent.com/48202197/196462919-c78752c1-c832-469f-b03c-32dc69821b65.png)


# 페이지 달기 

pageTest.jsp
============

<%@page import="java.util.List"%>
<%@page import="kr.co.seoulit.common.to.ListForm"%>
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		td { border:2 solid green; }
	</style>
</head>

<body>
	<%
	MemberDAO dao=MemberDAOImpl.getInstance();  // 싱글톤 패턴을 이용한 DAO 주소값 받아오기 [ 확장성을 위해 부모타입 자료형 ]	
	String param=request.getParameter("pn"); // 쿼리스트링 값을 'pn'으로 받아서 저장 
	int pagenum= param==null ? 1 : Integer.parseInt(param); // 3항 연산자를 이용 위에서 전달받은 값이 있을 때와 없을 때 값을 다르게 저장
	ListForm listform=new ListForm(); // 리스트폼의 객체(주소) 생성
	listform.setPagenum(pagenum); // setPagenum() 메서드를 호출해서 [페이지 번호를 셋팅] 
	listform.setDbcount(dao.selectRowCount()); // setDbcount() 메서드를 호출해서 [전체 행갯수를 셋팅]
	int sr=listform.getStartrow(); // getStartrow() 메서드를 호출해서 시작행 번호를 변수에 저장
	int er=listform.getEndrow(); // getEndrow() 메서드를 호출해서 종료행 번호를 변수에 저장
	List<MemberBean> list=MemberDAOImpl.getInstance().selectMemberList(sr,er); 
	// 싱글톤 패턴을 이용한 DAO 주소값 받아오기 바로 selectMemberList(sr,er) 메서드 호출 [반환형: List<MemberBean> ] 리스트에 값을  담음
	%>
	
<h1>회원목록</h1>

	<table>
	<%
	int num=sr; // 시작행번호
	for(MemberBean member:list){ // 확장 for문을 이용해서 내용을 출력
	%>
		<tr>
		<td><%=num++%></td> 
		<td><%=member.getId()%></td> 
		<td><%=member.getPw()%></td>
		<td><%=member.getAddr()%></td>
		<td><%=member.getTel()%></td>
		</tr>
	<% }%>
	</table>
	
	<%
	if(listform.isPrevious()){ // isPrevious()메서드 호출 이전 페이지 묶음이 존재한다면 페이지묶음 -1을 셋팅
	%>
		<a href="page.jsp?pn=<%=pagenum-1%>">◀</a>
	<%
	}
	
	for(int n=listform.getStartpage(); n<=listform.getEndpage(); n++){ // 페이지 이동 셋팅
	%>
		<a href="page.jsp?pn=<%=n%>"><%=n%>&nbsp;</a>
	<%
	}
	
	if(listform.isNext()){ // isNext()메서드 호출 다음 페이지 묶음이 존재한다면 페이지묶음 +1을 셋팅
	%>
		<a href="page.jsp?pn=<%=pagenum+1%>">▶</a>
	<%
	}
	%>
</body>
</html>

MemberDAOImpl.java
==================
[쿼리문]
select * 
FROM (select rownum as rn, id, pw, addr, tel from select * from member order by id) t 
where t.rn between ? and ?;


	public List<MemberBean> selectMemberList(int sr, int er){ 
		// [반환형이 : List<MemberBean>]인 메서드
		// 페이지 시작행 번호와 종료행 번호를 매개변수로 가짐
		ArrayList<MemberBean> v=new ArrayList<MemberBean>(); // DB연동 값을 담을 ArrayList<> 생성
		Connection con = null; 
		PreparedStatement pstmt = null;
		try { // [ 쿼리문 -> rownum의 범위가 sr ~ er의 값을 받아오는 내용 ]
			StringBuffer query = new StringBuffer();
			query.append("select * from ");
			query.append("(select rownum as rn, id, pw, addr, tel from ");
			query.append("(select * from member order by id)) t ");
			query.append("where t.rn between ? and ?");

			DataSource dataSource=ServiceLocator.getInstance().getDataSource("jdbc/myoracle");
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query.toString()); // prepareStatement(쿼리문) 변수 값을 포함함 쿼리문 작성
			pstmt.setInt(1, sr); // 첫번째 ? 값을 셋팅 
			pstmt.setInt(2, er); // 두번째 ? 값을 셋팅
			ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행 값을 변수에 저장
			while(rs.next()){ // 반목문을 이용해서 결과 값을 bean 객체에 저장
				MemberBean member=new MemberBean();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setAddr(rs.getString("addr"));
				member.setTel(rs.getString("tel"));
				v.add(member); // 처음에 생성한 ArrayList<> bean 객체를 셋팅
			}
			return v; // ArrayList<>를 반환
		} catch(Exception sqle) { // 예외처리
			throw new DataAccessException(sqle.getMessage());			
		} finally { 
			try{ // 자원정리 
				if(pstmt!=null){pstmt.close(); pstmt=null;}
				if(con!=null){con.close(); con=null; }
			}catch(Exception e){throw new RuntimeException(e.getMessage());}		
		}
	}


[쿼리문]
select count(*) from member

	public int selectRowCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try { // 쿼리문 DB 연동 부분에서 입력변수가 없는데 왜 Statement()가 아닌지는 잘모르겠지만 PreparedStatement()도 상관없는것 같다 
			StringBuffer query = new StringBuffer();
			query.append("select count(*) from member");
			DataSource dataSource=ServiceLocator.getInstance().getDataSource("jdbc/myoracle");
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query.toString());
			rs=pstmt.executeQuery();
			rs.next();
			return rs.getInt(1); // getInt(1) 메서드를 호출해서 결과값의 1행 갯수를 INT로 반환 받는다
		} catch(Exception sqle) { // 예외처리
			throw new DataAccessException(sqle.getMessage());			
		} finally {
			try{ // 자원정리
			if(rs!=null){ rs.close(); rs=null; }
			if(pstmt!=null){ pstmt.close(); pstmt=null; }
			if(con!=null){ con.close(); con=null; }
			}catch(Exception e){throw new DataAccessException(e.getMessage()); }
		}
	}}


listform.java
=============
package kr.co.seoulit.common.to;

import java.util.List;

public class ListForm {
		private int				endrow=1;			// 보여지는 화면의 끝줄
		private int 			pagenum=1;			// 현재페이지번호
		private int 			rowsize=3;		    // 화면에 보여질 줄갯수
		private int 			endpage=1;			// 끝페이지
		private int				pagesize=2;			// 화면에 보여질 페이지갯수
		private int 			pagecount;			// 총페이지갯수
		private int 			dbcount;			// 총레코드갯수	
		private List<?> 		list;				// 리스트 폼을 보관할 수 있는 리스트 [ memberList // empList // 등등 동일한 처리가 필요한 다양한 테이블의 자료를 저장 ]
		// 계산을 위한 변수 셋팅 메서드
		public void setPagenum(int pagenum){
			this.pagenum=pagenum;
		}
		
		public void setDbcount(int dbcount){
			this.dbcount=dbcount;
		}
		
		public void setRowsize(int rowsize){
			this.rowsize=rowsize;
		}
		// 출력을 위한 계산된 변수를 반환하는 메서드
		public int getPagenum(){
			return pagenum;
		}
		public int getStartrow(){
			return (getPagenum()-1)*getRowsize()+1;
		}
		public int getEndrow(){
			endrow= getStartrow()+getRowsize()-1;   
			
			if(endrow>getDbcount())
				endrow = getDbcount();
			return endrow;
		}
		public int getRowsize(){
			return rowsize;
		}
	
		public int getDbcount(){
			return dbcount;
		}
		public int getStartpage(){
			return getPagenum()-((getPagenum()-1)%getPagesize());
		}
		public int getEndpage(){
			endpage= getStartpage()+getPagesize()-1;
			if(endpage>getPagecount())
				endpage = getPagecount();
			return endpage;
		}
		public int getPagesize(){
			return pagesize;
		}
		public int getPagecount(){
			pagecount=(getDbcount()-1)/getRowsize()+1;
			return pagecount;	
		}
		// 페이지 묶음의 존재 여부를 판단해서 알려주는 메서드 
		public boolean isPrevious(){
			if(getStartpage()-getPagesize()>0)
				return true;
			else	return false;
		}
		public boolean isNext(){
			if(getStartpage()+getPagesize()<=getPagecount())
				return true;
			else 	return false;
		}
		// 다양한 주제의 페이지 달기 자료를 셋팅하고 받아올 수 있는 메서드
		public void setList(List<?> list){
			this.list=list;
		}
		public List<?> getList(){
			return list;
		}
	}



--------------------------------------------------------------------------------------------

[연습문제] 페이지 이동을 링크가 아니라 버튼으로 변경하는 코드를 작성해보자    ( jQuery를 사용 )

pageTest.jsp
===========
<%@page import="java.util.List"%>
<%@page import="kr.co.seoulit.common.to.ListForm"%>
<%@page import="kr.co.seoulit.member.to.MemberBean"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAO"%>
<%@page import="kr.co.seoulit.member.dao.MemberDAOImpl"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		td { border:2 solid green; }
	</style>
	<script src="http://code.jquery.com/jquery-1.7.js"></script>
	<script>
	$(document).ready(function(){
		$(":button[type='submit']").click(f) // jQuery를 이용한 이벤트 처리
	})
	function f(){
	let pNum=$(this).val(); // value 속성에 저장해둔 값을 호출
	$("input[name='pn']").val(pNum); // 쿼리 스트링으로 페이지값을 전달해주기 위해서 값을 넣어준다 
	}
	
	
	</script>
</head>

<body>
<%
MemberDAO dao=MemberDAOImpl.getInstance();

String param=request.getParameter("pn");
int pagenum= param==null ? 1 : Integer.parseInt(param);
ListForm listform=new ListForm();
listform.setPagenum(pagenum);
listform.setDbcount(dao.selectRowCount());
int sr=listform.getStartrow();
int er=listform.getEndrow();
List<MemberBean> list=MemberDAOImpl.getInstance().selectMemberList(sr,er);
%>
<h1>회원목록</h1>
<table>
<%
int num=sr;
for(MemberBean member:list){
%>
<tr>
<td><%=num++%></td>
<td><%=member.getId()%></td>
<td><%=member.getPw()%></td>
<td><%=member.getAddr()%></td>
<td><%=member.getTel()%></td>
</tr>
<% }%>
</table>
<form action="pageTest.jsp" name="ff">
<input type="hidden" name="pn">
<%
if(listform.isPrevious()){
%>
<a href="pageTest.jsp?pn=<%=pagenum-1%>">◀</a>
<%
}
for(int n=listform.getStartpage(); n<=listform.getEndpage(); n++){

%>
<button type="submit"  value=<%=n%>><%=n%>&nbsp;</button>  // value 값을 부여하고 이걸 불러오는 방법으로 처리했다 
<%
}
if(listform.isNext()){
%>
<a href="pageTest.jsp?pn=<%=pagenum+1%>">▶</a>
<%
}
%>
</form>
</body>
</html>


============================================================================
============================================================================


# usebean 엑션태그 [ baen 객체를 생성하는 엑션태그 ]

[sy]
<jsp: useBean id="[bean객체 이름]" class="[패키지 이름을 포함한 자바빈 클래스 이름]" scope="[범위]">


<jsp:useBean id="member"  class="kr.co.seoulit.member.to.MemberBean"  scope="session"/>

위의 내용을 기존의 방식으로 코드를 작성

[입력부분] 
MemberBean member= (MemberBean)request.getParameter("id, pw, addr, tel");
	if(member==null){
		member= new MemberBean();
		session.setAttribute("member",member);
	} 

[출력부분]	
MemberBean member= (MemberBean)session.getAttribute("member");
	if(member==null){
		// bean 객체가 등록되어 있지 않음 에러 발생 
	} 	
	
============================================================================
-------------------------------------------------------------------------------------------

memberForm.jsp
==============
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="join.jsp"> // 서밋했을 때 택스트 박스 내용을 쿼리스트링으로 받아서 페이지 이동( ...join.jsp?id=a&pw=b&addr=c&tel=d ) 
<input type="text" name="id" value="a"><br/>
<input type="text" name="pw" value="b"><br/>
<input type="text" name="addr" value="c"><br/>
<input type="text" name="tel" value="d"><br/>
<button type="submit">가입</button>
</form>
</body>
</html>


join.jsp
========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member"  class="kr.co.seoulit.member.to.MemberBean"  scope="session"/>
<jsp:setProperty property="*" name="member"/>
<%-- // 동일한 내용 bean 클래스의 변수와 parameter key 값이 동일하면 자동 셋팅이 된다
<jsp:setProperty property="id" name="member" value='<%=request.getParameter("id") %>' />
<jsp:setProperty property="pw" name="member" value='<%=request.getParameter("pw") %>' />
<jsp:setProperty property="addr" name="member" value='<%=request.getParameter("addr") %>' />
<jsp:setProperty property="tel" name="member" value='<%=request.getParameter("tel") %>' />
 --%>
<a href="view.jsp">회원정보보기</a>
</body>
</html>

[추가] 만약에 페이지 이동을 <jsp:forward page="view.jsp"></jsp:forward> 방식으로 할경우 // url을 변경하지 않고 페이지이동
<jsp:useBean의 범위를 scope="request"로 사용할 수 있다 > 


view.jsp
========
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="kr.co.seoulit.member.to.MemberBean"  scope="session"/>
<jsp:getProperty property="id" name="member" /><br/>
<jsp:getProperty property="pw" name="member" /><br/>
<jsp:getProperty property="addr" name="member" /><br/>
<jsp:getProperty property="tel" name="member" /><br/>
</body>
</html>


============================================================================
============================================================================

# jQuery [ 선택자 ]

# jQuery를 통해서 원하는 element를 가져오는 3가지 방법 [기본 선택자]
 
1 element의 태그명을 이용해서 호출하는 방법       예) $("div")
2 css class 속성을 이용하는 방법        예) $(".class1")
3 id 속성을 이용하는 방법         예) $("#id1")


## 선택자  

1. $("선택자, 선택자2, 선택자3,....") - 선택자 다수를 한번에 선택 가능하다 (중복을 허용한다)  [ 반환형 : Array<Element> ] 

2. $("부모선택자  자식선택자") - 부모객체의 해당 자식객체들을 반환    [ 반환형 : Array<Element> ] 
3. $("부모선택자 > 자식선택자") - 부모객체의 [직계 자식객체(=인접한 노드)]중  해당 자식 선택자인 객체들을 반환    [ 반환형 : Array<Element> ] 
4. $("기준선택자 + 대상선택자") - 기준선택자를 기준으로 [같은 노드 레벨의 인접한 대상] 즉 바로 다음에 등장하는 선택자 객체 반환    [ 반환형 : Array<Element> ] 
5. $("기준선택자 ~ 대상선택자") - 기준선택자를 기준으로 다음에 등장하는 [같은 노드 레벨]의 대상 선택자 객체들을 반환    [ 반환형 : Array<Element> ] 

6. $("선택자 : fisrt") - 첫번째 선택자 객체  [ 반환형 : Element ] 
7. $("선택자 : last") -  마지막 선택자 객체  [ 반환형 : Element ]   

8. $("선택자1 : not (선택자2)") - 선택자1중 (선택자2)가 아닌 객체	 [ 반환형 : Array<Element> ]    [중요함 꼭 확인해서 숙지 : 괄호 써주는거 잊지말자]

9. $("선택자 : even") - 선택자인 객체들중에 짝수에 해당하는 객체들을 반환  [ 반환형 : Array<Element> ]
10. $("선택자 : odd") - 선택자인 객체들중에 홀수에 해당하는 객체들을 반환  [ 반환형 : Array<Element> ]

11. $("선택자 : eq(index)") - 선택자인 객체들중에 인댁스 값인 객체를 반환 [ 반환형 : Element ] 
12. $("선택자 : gt(index)") - 선택자인 객체들중에 인댁스 값보다 큰 객체를 반환		[ 반환형 : Array<Element> ]
13. $("선택자 : lt(index)") - 선택자인 객체들중에 인댁스 값보다 작은 객체를 반환	[ 반환형 : Array<Element> ]

14. $("선택자 : contains('문자열')") - 선택자인 객체들중에 문자열 값을 포함하고 있는 객체들을 반환 	[ 반환형 : Array<Element> ]
15. $("선택자 : empty") -  선택자인 객체들중에서 자식 노드가 존재하지 않고 text 속성이 비어있는 객체들을 반환 	[ 반환형 : Array<Element> ]
16. $("선택자1 : has(선택자2)") -  선택자1인 객체들중에서 자식 노드가 선택자2인 대상의 객체들을 반환   [ 반환형 : Array<Element> ]
17. $("선택자 : parent") - 선택자인 객체들중에서 자식 노드가 존재하거나 text 속성이 값이있는 객체들을 반환		[ 반환형 : Array<Element> ]

18. $("선택자 : hidden") - 선택자의 [style 속성 값중 none]으로 되어 있는 경우와 [input type 속성 값이 hidden]으로 되어 있는 모든 대상  [ 반환형 : Array<Element> ] [중요함 꼭 확인해서 숙지 ]
	$(": hidden", "선택자") - 선택자와 모든 하위 노드 까지 속성을 체크

19. $("선택자[속성명]") - 선택자인 객체들중에서 해당 속성명의 속성을 가지는 객체들을 반환 	[ 반환형 : Array<Element> ]
20. $("선택자[속성명='값']") - 선택자인 객체들중에서 해당 속성명의 해당 속성 값을 가지는 객체들을 반환 	[ 반환형 : Array<Element> ]
21. $("선택자[속성명!='값']") - 선택자인 객체들중에서 해당 속성명의 해당 속성 값을 가지지않는 객체들을 반환 	[ 반환형 : Array<Element> ]
22. $("선택자[속성명^='값']") - 선택자인 객체들중에서 해당 속성명의 해당 속성 값이 입력 값으로 시작하는 객체들을 반환 	[ 반환형 : Array<Element> ]
23. $("선택자[속성명$='값']") - 선택자인 객체들중에서 해당 속성명의 해당 속성 값이 입력 값으로 끝나는 객체들을 반환 	[ 반환형 : Array<Element> ]
24. $("선택자[속성명*='값']") - 선택자인 객체들중에서 해당 속성명의 해당 속성 값이 포함되어 있는 객체들을 반환 	[ 반환형 : Array<Element> ]
25. $("선택자[속성1][속성2][속성3] - 선택자인 객체들중에서 입력값으로 받은 속성값을 모두 만족하는 객체들을 반환 	[ 반환형 : Array<Element> ]

26. $("선택자 : fisrt-child") - 선택자인 객체들을 부모 노드를 기준으로 첫 번째 자식객체인 경우 각각 반환 	[ 반환형 : Array<Element> ] // 지가 첫째 자식이면 ok
27. $("선택자 : last-child") - 선택자인 객체들을 부모 노드를 기준으로 마지막 자식객체인 경우 각각 반환 	[ 반환형 : Array<Element> ] // 지가 마지막 자식이면 ok
28. $("선택자 : only-child") - 선택자인 객체들을 부모 노드를 기준으로 자식객체가 단 하나만 존재하는 경우 각각 반환 	[ 반환형 : Array<Element> ] // 지가 외동 자식이면 ok

29. $(":input") - form 태그 관련 입력 태그들을 모두 반환 	[ 반환형 : Array<Element> ] 	 [중요함 꼭 확인해서 숙지 ]

[ 위의 내용을 조합하고 중첩해서 사용이 가능하다 이부분은 여러가지 코드를 접하면서 숙지 ]

$('input:radio:checked')
$(":input[name='news']:not('selected')")


============================================================================

[예제문제1] 테이블의 짝수열과 홀수열의 배경색을 각각 변경해보자 ( jQuery를 사용 )

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
$(document).ready(function(){
    $('tr:odd').css('background-color','yellow')  // tr태그중 홀수값의 배경색을 변경하라 [ 배열은 0부터 시작 ]
    $('tr:even').css('background-color','tomato') // tr태그중 짝수값의 배경색을 변경하라 [ 배열은 0부터 시작 (0은 짝수)]   
    })
    </script>
</head>
<body>
<table>
<tr><td>1</td><td>2</td><td>3</td></tr>
<tr><td>1</td><td>2</td><td>3</td></tr>
<tr><td>1</td><td>2</td><td>3</td></tr>
<tr><td>1</td><td>2</td><td>3</td></tr>
<tr><td>1</td><td>2</td><td>3</td></tr>
</table>
</body>
</html>


-------------------------------------------------------------------------------------------------------

[예제문제2] 버튼을 눌렀을 때 리스트중 선택된 값을 출력하는 코드를 작성해보자   ( jQuery를 사용 )

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script>
    $(document).ready(function(){
        //$("form[name='ff'] :input:button[name=´bb´]").click(outFunc)
        //$(":input:button[name='bb']").click(outFunc)
        //$(":button[name='bb']").click(outFunc)
        $("[name='bb']").click(outFunc)
    })

    function outFunc(){ // 간단한게 표현한 내용
        let optionObj=$(":selected");
        let textObj=$("[name='txt']");
        $(textObj).val($(optionObj).val());

        // let optionObj=$("form[name=´ff´] :selected");
        // let textObj=$("form[name=´ff´] :input[name=´txt´]");
        // $(textObj).val($(optionObj).val());
    }

</script>
</head>
<body>
    <form name="ff">
        <select name="sel">
        <option>aa</option>
        <option>bb</option>
        <option>cc</option>
        </select>
        <button type="button" name="bb">선택된것은?</button>
        <input type="text" name="txt">
    </form>
</body>
</html>


[예제문제3] 버튼을 눌렀을 때 리스트중 다중 선택된 값을 모두 출력하는 코드를 작성해보자  ( jQuery를 사용 ) 
[ $.each( 배열, callback함수 ( index, element ){} ) - 반복문중 가장 속도가 빠르다 자주 이용하자 ]

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script>
    $(document).ready(function(){
        $(":input:button[name='bb']").click(outFunc)
    })

    function outFunc(){
        let optionObj=$("select[name='sel'] :selected"); // 일부러 가장 길고 자세하게 선택자를 기술함 ( :selected 만 써도 됨)
        let textObj=$("form[name='ff'] :input:text[name='txt']");  // 일부러 가장 길고 자세하게 선택자를 기술함 ( [name='txt'] 만 써도 됨)

        let str=""; // val()값을 누적시킬 비 문자열 변수 생성
        $.each(optionObj, function(index, element){ // 반복문을 이용해서 문자열 누적
            str+=$(element).val()+", ";
        })

        $(textObj).val(str); // 출력
    }

</script>
</head>
<body>
    <form name="ff">
        <select name="sel" multiple>
        <option>aa</option>
        <option>bb</option>
        <option>cc</option>
        </select>
        <button type="button" name="bb">선택된것은?</button>
        <input type="text" name="txt">
    </form>
</body>
</html>


[예제문제4] 체크박스를 선택했을 때 모든 체크박스가 선택되도록하는 코드를 작성해보자  ( jQuery를 사용 ) 

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
    $(document).ready(function(){
        $(':input:checkbox').click(fullCheck);
    });
    function fullCheck(){
        let why= $(this).prop("checked");
        let arrayCheckbox=$(':checkbox')
        //$(":input:checkbox").attr("checked",why);
        $.each(arrayCheckbox, function(index, element){
        $(element).attr('checked',why);
        })
    }
</script>
</head>
<body>
    <input type="checkbox">
    <input type="checkbox">
    <input type="checkbox">
    <input type="checkbox">
    <input type="checkbox">
    <input type="checkbox">
</body>
</html>
============================================================================
![image](https://user-images.githubusercontent.com/48202197/196462852-100e4fea-efb2-4601-b804-17e2e5128c50.png)

	
## 서블릿

서블릿 클래스를 구현하면 먼저 [ HttpServlet ]클래스를 상속받은 클래스를 작성해야한다.
즉, 모든 서블릿은 HttpServlet 클래스의 자식 클래스이다 

지금까지 jsp 파일 접근방법 >> http//localhost:8282/프로젝트명/파일명.jsp
생성한 서블릿으로 접근방법 >> http//localhost:8282/프로젝트명/서블릿명
[ 동일한 서블릿 명으로 묶여있는 서블릿 클래스의 doGet() 메서드를 호출 ]


# 이클립스에서 서블릿 생성방법

[프로젝트/Java Sesources/src]에서 서블릿 생성 [ 패키지명, 서블릿명 입력 ]

예를들어 [프로젝트/Java Sesources/src]에서 [a.b 패키지]에 [Test1 서블릿]을 생성하면

[프로젝트/Java Sesources/src]/ a.b 패키지 / Test1.java 파일 생성 [ doGet(), doPost() 메서드를 포함 ]
[프로젝트/WebContent/WEB-INF]/ web.xml 파일에는 자동으로 아래의 코드가 추가된다

web.xml
=======

<servlet>
    <servlet-name>Test1</servlet-name>
    <servlet-class>a.b.Test1</servlet-class> // 실제로 호출하는 class 파일 [ a/b/Test1.java ]
</servlet>
<servlet-mapping>
    <servlet-name>Test1</servlet-name>
    <url-pattern>/Test1</url-pattern>    // 서블릿으로 접근하는 url주소
</servlet-mapping>

==========================================================================================
http//localhost:8282/프로젝트명/Test1 << 접근가능

------------------------------------------------------------------------------------------


# 콜백메서드 : 메서드가 자동으로 호출되는 메서드
 doGet(), doPost(), init(), destroy()

- doGet 메서드 호출시점 : url이나 form태그 기본값으로 설정
- doPost 메서드 호출시점 : <form action="/프로젝트명/파일명" method="post">
- init 메서드 호출시점 : 최초 접속 요청시 1회만 호출 일반적으로 tomcat 서버가 시작될 때 호출 되도록 web.xml의 서블릿 태그 내부에 <load-on-startup>양의정수</load-on-startup>로 설정해서 사용 
- destroy 메서드 호출시점 : tomcat 서버가 종료될 때 호출 됨


# 클라이언트가 접속할 대 호출되는 doGet() 메서드에 코드 추가해보기

Test1.java
==========
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html; charset=UTF-8");   // 응답시 어떤 양식의 자료인지 text/html; 문자열 변환형식은 무엇인지  UTF-8 ( 한글이나 특수문자 깨짐 방지 ) 설정
	request.setCharacterEncoding("utf-8");	//  요청시 문자열 변환형식 UTF-8 ( 한글이나 특수문자 깨짐 방지 )
	
	// doGet() 메서드에서 jsp 내장객체들은 바로 사용할 수 없으므로 객체를 생성해서 사용해야한다 
	// 서블릿의 부모인 [ HttpServlet 클래스 ]의 메서드를 이용해서 객체를 받아와서 사용할 수 있다
	// request, response 객체의 경우 매개변수로 전달받고 있다
	
	PrintWriter out=response.getWriter();   // out 객체
	ServletConfig config=this.getServletConfig();  // ServletConfig 객체
	ServletContext application=this.getServletContext(); // ServletContext 객체 
	
}


------------------------------------------------------------------------------------------

# 서블릿에서 화면이동하기

1. response 객체 이용
 response.sendRedirect("경로");

2. forward 의 경우 ( URL 경로가 바뀌지 않고 화면이동 )
 RequestDispatcher rd=request.getRequestDispatcher("경로");
 rd.forward(request, response);


------------------------------------------------------------------------------------------

#   web.xml 파일 내부에 <init-param> & <context-param> 호출하기  [ MVC 패턴에서 사용 ]

web.xml
=======
<web-app>
  <servlet> // 서블릿
    <servlet-name>test1</servlet-name>
    <servlet-class>a.b.test1</servlet-class> // 실제로 호출하는 class 파일 [ a/b/Test1.java ]
	<load-on-startup>1</load-on-startup>     // 톰캣서버를 실행했을 때 init()메서드를 자동으로 실행하도록 설정
	
	  <init-param>	// [test1 서블릿에서만] 호출이 가능한 parameter  [ config.getInitParameter("abc") ]
		  <param-name>abc</param-name>
		  <param-value>def</param-value>
      </init-param>
	
  </servlet>
 
 <servlet-mapping>
    <servlet-name>test1</servlet-name>
    <url-pattern>/abc</url-pattern>     // 서블릿으로 접근하는 url주소
 </servlet-mapping>

	  <context-param> // [어플리케이션] 어디서든 호출이 가능한 parameter [ application.getInitParameter("aaa") ]
			<param-name>aaa</param-name>
			<param-value>bbb</param-value>
	  </context-param>
</web-app>
  
  
----------------------------------------------------------------------------------------------
==============================================================================================
==============================================================================================

### MVC 패턴

web.xml
=======
<?xml version="1.0" encoding="UTF-8"?>
<web-app>
  <display-name>mvcTest</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
  </welcome-file-list>


   <servlet>  // 1번 서블릿 [ main ]
    <servlet-name>main</servlet-name>
    <servlet-class>kr.co.seoulit.common.servlet.DispatcherServlet</servlet-class> // 실제로 호출하는 class 파일 [ 패키지명/DispatcherServlet.java ]
    <init-param> // [1번 서블릿에서만] 호출이 가능한 parameter  [ config.getInitParameter("파라미터이름") ]
      <param-name>configFile</param-name>
      <param-value>/WEB-INF/config/main.properties</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>  // 톰캣 서버가 시작될 때 1번으로 init() 메서드 호출
  </servlet>
  <servlet-mapping>
    <servlet-name>main</servlet-name>
    <url-pattern>*.do</url-pattern>      // [localhost:8282/mvcTest/*.do]로 서블릿 접근
  </servlet-mapping>
  <servlet-mapping>
    <servlet-name>main</servlet-name>
    <url-pattern>*.html</url-pattern>    // [localhost:8282/mvcTest/*.html]로 서블릿 접근
  </servlet-mapping>


  <servlet> // 2번 서블릿 [ member ]
    <servlet-name>member</servlet-name>
    <servlet-class>kr.co.seoulit.common.servlet.DispatcherServlet</servlet-class>  // 실제로 호출하는 class 파일 [ 패키지명/DispatcherServlet.java ]
    <init-param> // [2번 서블릿에서만] 호출이 가능한 parameter  [ config.getInitParameter("파라미터이름") ]
      <param-name>configFile</param-name>
      <param-value>/WEB-INF/config/member.properties</param-value>
    </init-param>
    <load-on-startup>2</load-on-startup> // 톰캣 서버가 시작될 때 2번으로 init() 메서드 호출
  </servlet>
  <servlet-mapping>
    <servlet-name>member</servlet-name>
    <url-pattern>/member/*</url-pattern> // [localhost:8282/mvcTest/member/*]로 서블릿 접근
  </servlet-mapping>


  <context-param> // [어플리케이션] 어디서든 호출이 가능한 parameter [ application.getInitParameter("파라미터이름") ]
    <param-name>urlmappingFile</param-name>
    <param-value>/WEB-INF/config/urlmapping.properties</param-value>
  </context-param>
  <context-param>
    <param-name>pathFile</param-name>
    <param-value>/WEB-INF/config/path.properties</param-value>
  </context-param> 
</web-app>


// web.xml 파일에서 알수 있는 부분 [ 개인적인 의견 ]
1. 서블릿이 2개 있다 ( "main", "member" )
2. 서블릿 내부에 [ <load-on-startup>양수</load-on-startup> ] 태그가 있으니까 톰캣 서버가 켜지면 init() 메서드를 순서대로 호출할거다
3. 서블릿 명으로 접속하면 실제로 호출하는 class 파일은 [ 패키지명/DispatcherServlet.java ]이다 ( 두 서블릿이 같은 class 파일을 호출한다 하지만 다른 객체 주소값이 다르다 )
4. 서블릿 마다 <init-param>을 1개씩 가지고 있다 어플리케이션은 <context-param>을 2개 가지고 있다 [ 조만간 호출해서 써먹을거 같다 ]


==============================================================================================
==============================================================================================

## API

>> public abstract class GenericServlet extends Object  추상클래스 Object를 상속받고 있다
	>> public abstract class HttpServlet extends GenericServlet 추상클래스  GenericServlet를 상속받고 있다
		>> public class DispatcherServlet extends HttpServlet  클래스 HttpServlet 상속받고 있다
		
GenericServlet 클래스의 메서드 
 >> public void init() throws ServletException [반환형이 없는 메서드] :  JSP 내장객체 config를 사용할때 super.init(config)를 호출 할 필요가 없도록 해주는 메서드 (약간 생성자처럼 셋팅해두는거 같음) 
 >> public ServletContext getServletContext() [반환형이 ServletContext ] : JSP 내장객체 application을 사용할 때 호출하는 메서드


==============================================================================================
==============================================================================================


DispatcherServlet.java
======================

package kr.co.seoulit.common.servlet; // 패키지명 

// IOException import
import java.io.IOException;   

// JSP 내장객체들 import
import javax.servlet.ServletConfig;    
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 아직 먼지 잘모르겠는데 대충 써먹을 패키지의 클래스 파일이겠거니 생각한다
import kr.co.seoulit.common.servlet.context.ApplicationContext;
import kr.co.seoulit.common.servlet.mapper.SimpleUrlHandlerMapping;
import kr.co.seoulit.common.servlet.mvc.Controller;
import kr.co.seoulit.common.servlet.view.InternalResourceViewResolver;


public class DispatcherServlet extends HttpServlet { // 서블릿이니까 당연히 [ HttpServlet ] 상속받아야 함
	private static final long serialVersionUID = 1L; // 모르는 내용
	
	// 맴버변수를 private으로 2개 생성
	private ApplicationContext applicationContext;  	
	private SimpleUrlHandlerMapping simpleUrlHandlerMapping;

	// 생성자에서는 아무일도 일어나지 않는다
    public DispatcherServlet() {
    }

    
    
    // init() 메서드 톰캣 가동시 호출
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// GenericServlet 클래스의 init() 메서드 내장 객체 config를 사용할 때 객체를 생성해서 별도로 호출 할 필요가 없도록 오버라이드 할 수 있는 편리한 메소드
		ServletContext application=this.getServletContext(); // JSP 내장객체 ServletContext를 반환받아서 사용
		applicationContext=new ApplicationContext(config,application); // 위에서 정의한 맴버변수에 객체를 생성해서 초기화 매개변수로 내장객체  (config, application)를 가진다
		simpleUrlHandlerMapping=SimpleUrlHandlerMapping.getInstance(application); // 위에서 정의한 맴버변수에 싱글톤 패턴을 이용해서 객체의 주소값을 전달받음 매개변수로 내장객체 (application)를 가진다
	}



	// 클라이언트가 접속하면 호출되는 메서드 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);  // doPost(request,response)를 호출하도록 설정
	}



	// 일반적으로 method가 post방식일 경우에만 호출되는 메서드이나 이번에는 doGet()메서드 내부에서 호출해서 사용하고 있으므로 공통적으로 두 메서드는 클라이언드가 접속하면 호출된다 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // 응답시 어떤 양식의 자료인지 text/html; 문자열 변환형식은 무엇인지  UTF-8 ( 한글이나 특수문자 깨짐 방지 ) 설정
		response.setCharacterEncoding("utf-8"); //  요청시 문자열 변환형식 UTF-8 ( 한글이나 특수문자 깨짐 방지 )
		// 여기 아래부분은 추가 학습이 필요하다
		Controller controller=simpleUrlHandlerMapping.getController(applicationContext,request);
		ModelAndView modelAndView=controller.handleRequest(request,response);
		if(modelAndView!=null){
			ServletContext application=this.getServletContext();
			InternalResourceViewResolver.getInstance(application).resolveView(modelAndView,request,response);
		}
	}
}


=======================================================================================================================
=======================================================================================================================

ApplicationContext.java
=======================


package kr.co.seoulit.common.servlet.context; // 패키지명

// java se에서 사용했던 패키지 import
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

// JSP 내장객체들 import 
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;


public class ApplicationContext {
	private HashMap<String,Object> map;  // private 맴버변수로 HashMap<String,Object> 선언
	
	public ApplicationContext(ServletConfig config, ServletContext application){ 
	// 생성자 [ DispatcherServlet 서블릿의 init() 메서드에서 (config, application)를 메개변수에 담아서 객체를 생성했으니까 ] 호출됨
		map=new HashMap<String,Object>(); // 위에서 선언한 HashMap<String,Object>(); 객체 생성
		String path=config.getInitParameter("configFile"); // JSP 내장객체 config( 매개변수로 전달됨 ) 서블릿에 셋팅된 <init-param> 값을 호출해서 문자열 변수에 담음 [ 예) main 서블릿 : /WEB-INF/config/main.properties ]
		System.out.println("configFile:"+path); // 콘솔창에 한번 출력
		String rPath=application.getRealPath(path); // JSP 내장객체 application( 매개변수로 전달됨 )의 getRealPath('프로퍼티 파일명')메서드 호출 [ 절대경로 알려주는 메서드 ]
		Properties properties=new Properties(); // 프로퍼티 객체를 선언 및 생성해주고
		try {
			properties.load(new FileReader(rPath)); // 프로퍼티 객체의 load()메서드를 호출해서 해당 [프로퍼티 값을 저장하고 있는 txt 파일]을 불러온다
		} catch (FileNotFoundException e) { // 예외처리를 해주는 부분
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Set<String> set=properties.stringPropertyNames(); // 프로퍼티 객체의 stringPropertyNames()메서드를 호출 [ 불러온 파일의 저장된 프로퍼티의 키 값들을 set 형태로 모아서 리턴 ]
		for(String key: set){ // 중첩 for문을 활용 [ 위에서 생성한 HashMap에 [프로퍼티 키], [프로퍼티 벨류 값의 객체] 형태로 모아서 저장하고자 한다 ]
			String value=properties.getProperty(key); //  프로퍼티 객체의 getProperty([프로퍼티 키]) 메서드를 호출해서 [프로퍼티 벨류] 값을 문자열로 변수에 저장
			Object obj = null;  // 확장성을 위해 Object 형태로 변수를 하나 만들어주고 [ 확장성을 높인다 : 최대한 부모타입을 써서 자료형에 무관하게 보관할 수 있게 만든다 ] 
			try {
				obj = Class.forName(value).newInstance(); 
				// class 클래스에 있는 forName([프로퍼티 키]) 메서드를 호출 메모리에 클래스를 올리고 newInstance() 메서드를 호출해서 객체값을 반환받는다 [ 자바 리플렉트 수업 부분 참고 ]
			} catch (InstantiationException e) { // 예외처리를 해주는 부분
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			map.put(key,obj); // 위해서 객체를 생성했으니까 [프로퍼티 키], [프로퍼티 벨류 값의 객체] 형태로 모아서 저장
		}
	}

	public Object getBean(String beanName) { // 반환형 Object 메서드 (형변환해서 사용하자) [ 예) getBean( "프로퍼티 키" ) -> [프로퍼티 벨류 값의 객체] ]
		return map.get(beanName);
	}
}


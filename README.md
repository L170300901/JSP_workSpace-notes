# JSP_workSpace-notes

JQuery 라이브러리 
 
[ JQuery 사용법 : https://api.jquery.com ]
 
API Documentation >>  .add() >>  [아래 JQuery 코드 붙여넣기]
 
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
 
=================================================================
 
JQuery 기본 문법
 
모든 객체는 $(내장객체) 혹은 $("선택자")를 이용해 호출한다 ( $ 대신에 jQuery를 써도 된다 )
 
$(document).ready( ); <<  엔터링 포인트
$(document) 내장객체 . ready(); 메서드
 
 
jQuery를 통해서 원하는 element를 가져오는 3가지 방법
 
1 element의 태그명을 이용해서 호출하는 방법       예) $("div")
2 css class 속성을 이용하는 방법        예) $(".class1")
3 id 속성을 이용하는 방법         예) $("#id1")
 
 
jQuery를 통해서 원하는 메서드를 사용하는방법 - 호출한 jQuery객체 + [. jQuery 메서드 ();]
 
$("[태그명], [#iD 값], [.class 값]"). jQuery의 메서드()
 
callback 함수 - 매개변수 자리에 위치한 이름이 없는 함수 ( 호출되면 바로 실행되는 특징을 가진다 ) 
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
 
 
선택자  
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

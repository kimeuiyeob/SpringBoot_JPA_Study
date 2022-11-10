/*
* item/list.html
* */
const $checkboxes = $("input[type='checkbox']"); /*list.html에 있는 체크박스*/
const $table = $("#cart");
const $pay = $("input#pay");
const names = ["itemNumber", "itemName", "itemCount"]

$checkboxes.on("click", function(){ /*체크박스에 클릭 이벤트 먹이기*/

    let index = $checkboxes.index($(this)); /*index($(this))체크 박스 클릭한 순서대로*/
    let $tds = $(this).closest("tr").children(); /*td 전부 (번호,이름,가격,재고)가 있다.*/

    let text = ""; /*담을 text변수 하나 생성*/

    if($(this).is(":checked")){ /*체크가 체크가 되었을시*/
        text += `<tr id="` + index + `">`;
        text += `<td><input value="` + $tds.eq(1).text() + `" readonly></td>`; /*.eq(1)은 첫번째 인덱스 = itemName, readonly로 수정불가하게 만든다.*/
        text += `<td><input value="` + $tds.eq(2).text() + `" readonly></td>`; /*.eq(2)은 두번째 인덱스 = itemPrice*/
        text += `<td><input placeholder="개수"></td>`; /*개수*/
        text += `</tr>`;

        $table.append(text); /*$("#cart")여기 텍스트안에다 넣는다.*/

    }else{
        $table.find("tr").remove("#" + index); /*체크 해제했을시 생긴 테이블을 지운다.*/
    }
});

$pay.on("click", function(){
    $table.find("tr input").each(function(i, input){
        $(input).attr("name", "orders[" + parseInt(i / 3) + "]." + names[i % 3]);
    });

    document.payForm.submit();
});























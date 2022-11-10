/*
* order/list.html
* */

const orderIds = $("tr td:first-child");
let orderIdSet = new Set();
let text = "";
orderIds.each(function(i, orderId){
    orderIdSet.add($(orderId).text());
});

orderIdSet.forEach(orderId => {
    text += `<tr>`;
    text += `<td><input type="checkbox" name="orderId" value="` + orderId + `"></td>`
    text += `<td>` + orderId + `</td>`
    text += `</tr>`;
});

$("table#order-list").append(text);
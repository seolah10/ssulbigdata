name = prompt("What's your name", "Park");
document.write("Welcome~ " + name);
function chk() {
    if (frm.tel.value < 4) {
        alert("전화번호 뒷자리는 4자리 이상 입력해주세요.");
        return false;
    }
}

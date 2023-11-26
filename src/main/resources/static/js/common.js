/*
 * 정의 : form데이터 API서버로 post요청 함수
 */
const com_formDataPostReq = async (url, formData) => {
    let resBodyObj = null;
    const reqJsonObj = JSON.stringify(Object.fromEntries(formData.entries()));
    await fetch(url, {
        method: 'post',
        headers: {
            "Content-Type": "application/json",
        },
        body: reqJsonObj
    })
        .then(async (response) => {
            return response.text();
        })
        .then(async (data) => {
            resBodyObj = JSON.parse(data)
        });

    if (resBodyObj.showMsgAlert) { //서버에서 전달한 경고 메시지있는 경우 출력
        alert(resBodyObj.message)
        return
    }
    return resBodyObj;
}
document.getElementById("statusSubmit").addEventListener("click", processSubmit);
window.addEventListener("load", getNewStatus);
var newStatusRequest = new XMLHttpRequest();
var statusUpdateRequest = new XMLHttpRequest();

function processSubmit() {
    console.log("click");
    var status = document.getElementById("status").value;
    document.getElementById("currentStatus").value = "";
    newStatusRequest.open("POST", "Controller?action=ChangeStatus", true);
    newStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    newStatusRequest.send("stat="+status);
}

function getNewStatus() {
    statusUpdateRequest.open("GET", "Controller?action=GetStatus", true);
    statusUpdateRequest.onreadystatechange = showStatus;
    statusUpdateRequest.send();
}

function showStatus() {
    console.log(statusUpdateRequest);
    if (statusUpdateRequest.readyState === 4){
        if (statusUpdateRequest.status === 200){
            var serverResponse = JSON.parse(statusUpdateRequest.responseText);
            var responseXML = serverResponse.stat;
            var statusElement = document.getElementById("currentStatus");
            statusElement.innerText = responseXML;

        }
    }
}

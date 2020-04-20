document.getElementById("addFriendSubmit").addEventListener("click", processSubmit);
window.addEventListener("load", refreshFriendlist);
var newFriendRequest = new XMLHttpRequest();

function processSubmit(){
    console.log("click");
    var username = document.getElementById("friends").value;
    newStatusRequest.open("POST", "Controller?action=AddFriend", true);
    newStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    newStatusRequest.send("username="+username);
    refreshFriendlist();
}

function refreshFriendlist(){
    setTimeout(refreshFriendlist, 10000);
    console.log("refresh");
    statusUpdateRequest.open("GET", "Controller?action=Friends", true);
    statusUpdateRequest.onreadystatechange = showFriends;
    statusUpdateRequest.send();
}
function showFriends() {
    if (statusUpdateRequest.readyState === 4){
        if (statusUpdateRequest.status === 200){
            var serverResponse = JSON.parse(statusUpdateRequest.responseText);
            clearAllChildren();
            var parent = document.getElementById("friendlist");
            for (var person in serverResponse){
                var li = document.createElement("LI");
                li.innerText = person + " " + serverResponse[person].status;
                parent.appendChild(li)
            }

        }
    }

}
function clearAllChildren() {
    var myNode = document.getElementById("friendlist");
    while (myNode.firstChild) {
        myNode.removeChild(myNode.lastChild);
    }
}
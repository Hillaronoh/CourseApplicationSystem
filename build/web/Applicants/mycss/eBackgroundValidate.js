/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function init() {
 
    document.getElementById("reset").onclick = clearDisplay;
  
    document.getElementById("name").focus();
}
 
function validateEducationBackgroundForm(thisForm) {
    with(thisForm) {
        return (isSelected(physicsgrade.value, physicsgrade, "Select Grade!", physicsgradeError)
                && isSelected(mathsgrade.value, mathsgrade, "Select Grade!", mathsgradeError)
                && isSelected(mathsgrade.value, mathsgrade, "Select Grade!", mathsgradeError)
                && isSelected(subj3.value, subj3, "Select Grade!", subj3Error)
                && isSelected(subj4.value, subj4, "Select Grade!", subj4Error)
                && isSelected(meangrade.value, meangrade, "Select Grade!", meangradeError)
                && isNumeric(aggregatepoints.value, aggregatepoints, "Should be between 0-84!",aggregatepointsError)
                && isLengthMinMax(aggregatepoints.value, 2, 2, aggregatepoints,"Should be between 0-84!", aggregatepointsError))
	       
    } 
}
 
function showMessageAndFocus(isValid, focusInputElm, errMsg, errElm) {
    if (!isValid) {
        if (errElm !== undefined && errElm !== null
                && errMsg !== undefined && errMsg !== null) {
            errElm.innerHTML = errMsg;
        }
        if (focusInputElm !== undefined && focusInputElm !== null) {
            focusInputElm.className = "error";
            focusInputElm.focus();
        }
    } else {
        if (errElm !== undefined && errElm !== null) {
            errElm.innerHTML = "";
        }
        if (focusInputElm !== undefined && focusInputElm !== null) {
            focusInputElm.className = "";
        }
    }
}
function isNotEmpty(inputValue, focusInputElm, errMsg, errElm) {
    var isValid = (inputValue !== null)
            && (inputValue.trim() !== "");
    showMessageAndFocus(isValid, focusInputElm, errMsg, errElm);
    return isValid;
}
function isNumeric(inputValue, focusInputElm, errMsg, errElm) {
    var isValid = (inputValue !== null
            && inputValue.trim().match(/^\d+$/) !== null);
    showMessageAndFocus(isValid, focusInputElm, errMsg, errElm);
    return isValid;
}
function isAlphabetic(inputValue, focusInputElm, errMsg, errElm) {
    var isValid = (inputValue !== null
            && inputValue.trim().match(/^[a-zA-Z]+$/) !== null) ;
    showMessageAndFocus(isValid, focusInputElm, errMsg, errElm);
    return isValid;
}
function isAlphanumeric(inputValue, focusInputElm, errMsg, errElm) {
    var isValid = (inputValue !== null
            && inputValue.trim().match(/^[0-9a-zA-Z]+$/) !== null);
    showMessageAndFocus(isValid, focusInputElm, errMsg, errElm);
    return isValid;
}
function isLengthMinMax(inputValue, minLength, maxLength, focusInputElm, errMsg, errElm) {
    var inputValue = inputValue.trim();
    var isValid = (inputValue.length >= minLength) && (inputValue.length <= maxLength);
    showMessageAndFocus(isValid, focusInputElm, errMsg, errElm);
    return isValid;
}
function isValidEmail(inputValue, focusInputElm, errMsg, errElm) {
    var isValid = (inputValue !== null)
            && (inputValue.trim().match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/) !== null);
    showMessageAndFocus(isValid, focusInputElm, errMsg, errElm);
    return isValid;
}
function isSelected(inputValue, focusInputElm, errMsg, errElm) {
    var isValid = (inputValue !== "");
    showMessageAndFocus(isValid, focusInputElm, errMsg, errElm);
    return isValid;
}
function isChecked(inputName, focusInputElm, errMsg, errElm) {
    var inputElements = document.getElementsByName(inputName);
    var isChecked = false;
    for (var i = 0; i < inputElements.length; i++) {
        if (inputElements[i].checked) {
            isChecked = true;
            break;
        }
    }
    showMessageAndFocus(isChecked, focusInputElm, errMsg, errElm);
    return isChecked;
}
function isValidPassword(inputValue, focusInputElm, errMsg, errElm) {
    var isValid = (inputValue !== null)
            && (inputValue.trim().match(/^\w{6,8}$/) !== null);
    showMessageAndFocus(isValid, focusInputElm, errMsg, errElm);
    return isValid;
}
function verifyPassword(pw, verifiedpw, focusInputElm, errMsg, errElm) {
    var isTheSame = (pw === verifiedpw);
    showMessageAndFocus(isTheSame, focusInputElm, errMsg, errElm);
    return isTheSame;
}
function clearDisplay() {
    var elms = document.getElementsByTagName("*"); 
    for (var i = 0; i < elms.length; i++) {
        if ((elms[i].id).match(/Error$/)) {
            elms[i].innerHTML = "";
        }
        if (elms[i].className === "error") { 
            elms[i].className = "";
        }
    }
 
    document.getElementById("name").focus();
}// JavaScript Document

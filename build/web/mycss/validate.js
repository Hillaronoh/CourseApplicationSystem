function init() {
 
   document.getElementById("reset").onclick = clearDisplay;
  
     document.getElementById("name").focus();
}
 
function validateForm(thisForm) {
   with(thisForm) {
      return (isNotEmpty(fname.value, fname, "First Name Required!",fnameError)
      && isAlphabetic(fname.value, fname, "Enter a valid Name!",fnameError)
      && isNotEmpty(lname.value, lname, "Last Name Required!",lnameError)
      && isAlphabetic(lname.value, lname, "Enter a valid Name!",lnameError)
      && isValidEmail(email.value, email, "Enter a valid Email Address!", emailError)
      && isValidPassword(password1.value, password1, "Password must be 6-8 characters!", password1Error)
      && verifyPassword(password1.value, password2.value, password2, "pasword mismatch!", password2Error)
	       
	 
	     	&& isNotEmpty(IdNo.value, IdNo, "Please enter Id number!",IdNoError)
		    && isLengthMinMax(IdNo.value, 9, 9, IdNo, "Please enter (9) digits!", IdNoError)
			&& isSelected(jobBased.value, jobBased, "Please select a job categoly", jobBasedError)
			&& isNumeric(contacts.value, contacts, "Please enter valid contacts",contactsError)
			&& isLengthMinMax(contacts.value, 10, 10, contacts,"Please enter valid telephone number", contactsError)
			
			
		   && isAlphabetic(jobBased.worker, wochi, jobBased, "please enter a valid name", Error)
           && isLengthMinMax(sid.value, 4, 6, sid,"Please enter (4 to 6) Station Id!", sidError)
		   && isNumeric(members.value, members, "Please enter No of members",membersError)
		   && isLengthMinMax(telno.value, 10, 10, telno,"Please enter valid(station) telephone number", telnoError)
           && isLengthMinMax(emergency.value, 10, 10, emergency,"Please enter valid emergency number",emergencyError)
		   && isNotEmpty(location.value, location, "Please enter Station's Location area",locationError)
		   && isNotEmpty(username.value, username, "Please enter(station) username",usernameError));
		   
           
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
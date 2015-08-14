/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//SECTION A: Applicant's Personal Details.
$("#myForm1").validate({
    rules:{
        fname:{
            required:true,
            lettersonly:true         
        },
        
        mname:{
            lettersonly:true
        },
        
        lname:{
            required:true,
            lettersonly:true
        },
        
        gender:{
            required:true
        },
        
        dob:{
            required:true
        },
        
        address:{
            required:true
        },
        
        mobile:{
            required:true,
            digits:true,
            rangelength:[10,10]
        },
        
        country:{
            required:true
        }
    },
    
    messages:{
        fname:{
            required: "Enter your first name!",
            lettersonly: "Name should contains letters only!"
        },
        
        lname:{
            required: "Enter your last name!",
            lettersonly: "Name should contains letters only!"
        },
        mname: "Name should contains letters only!",
        gender: "Select your gender!",
        dob: "Enter your date of birth!",
        address: "Enter your address!",
        mobile:{
            required: "Enter your phone number!",
            digits: "Phone number contains digits only!",
            rangelength: "Phone number is only 10 digits"
        },
        country: "Enter your country of residence!"
    }
});

//SECTION B: Applicant's Education Background.
$("#myForm2").validate({
    rules:{
        physics:{
            required:true
        },
        
        maths:{
            required:true
        },
        
        subj3:{
            required:true
        },
        
        subj4:{
            required:true
        },
        
        meanGrade:{
            required:true
        },
        
        aggregatePoints:{
            required:true,
            digits:true,
            min:20,
            max:84
        }
    },
    
    messages:{
        physics: "Choose your physics grade!",
        maths: "Choose your maths grade!",
        subj3: "Choose grade!",
        subj4: "Choose grade!",
        meanGrade: "Choose your mean grade!",
        aggregatePoints:{
            required:"Enter your aggregate points!",
            digits: "Aggregate points should be a whole number!",
            min: "Check your points, too low!",
            max: "Aggregate points cannot exceed 84"
        }
    }
});

//SECTION C: Course Application Details.
$("#myForm3").validate({
    rules:{
        programmeLevel:{
           required:true 
        },
        
        programmeName:{
            required:true
        },
        
        modeOfStudy:{
            required:true
        },
        
        campus:{
            required:true
        }
    },
    
    messages:{
        programmeLevel:"Select the programme level!",
        programmeName: "Select the programme name!",
        modeOfStudy:"Select mode of study!",
        campus:"Select campus!"
    } 
});

//Registration Form
$("#myForm4").validate({
    rules:{
        fname:{
            required:true,
            lettersonly:true         
        },
        
        mname:{
            lettersonly:true
        },
        
        lname:{
            required:true,
            lettersonly:true
        },
        
        email:{
            required:true,
            email:true
        },
        
        password1:{
            required:true
        },
        
        password2:{
            required:true,
            equalTo:"#password1"
        },
        
        oldPwd:{
            required:true
        }
    },
    
    messages:{
        fname:{
            required: "Enter your first name!",
            lettersonly: "Name should contains letters only!"
        },
        
        lname:{
            required: "Enter your last name!",
            lettersonly: "Name should contains letters only!"
        },
        mname: "Name should contains letters only!",
        
        email:{
            required:"Enter your email address!",
            email:"Enter a valid email address!"
        },
        password1:"Enter your password!",
        password2:{
            required:"Confirm your password!",
            equalTo:"Passwords should match!"
        },
        oldPwd: "Enter your current password!"
    }
});
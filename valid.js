function fun() {
    var userv = document.forms[0].user.value; 
    var pwdv = document.forms[0].pwd.value; 
    var emailv = document.forms[0].email.value; 
    var phv = document.forms[0].ph.value;

    var userreg = new RegExp("^[a-zA-Z][a-zA-Z0-9]*$");
    var emailreg = new RegExp("^[a-zA-Z][a-zA-Z0-9_.]*@[a-zA-Z][a-zA-Z0-9_.]*\\.[a-zA-Z]{2,}$");
    var phreg = new RegExp("^[0-9]{10}$");

    var ruser = userreg.test(userv);
    var remail = emailreg.test(emailv);
    var rph = phreg.test(phv);

    if (ruser && remail && rph && (pwdv.length >= 6)) {
        alert("All values are valid");
        return true;
    } else {
        if (!ruser) { 
            alert("Username invalid");
            document.forms[0].user.focus();
        } 
        if (!remail) { 
            alert("Email invalid");
            document.forms[0].email.focus();
        } 
        if (!rph) { 
            alert("Phone number invalid");
            document.forms[0].ph.focus();
        }
        if (pwdv.length < 6) { 
            alert("Password must be at least 6 characters long");
            document.forms[0].pwd.focus();
        }
        return false;
    }
}

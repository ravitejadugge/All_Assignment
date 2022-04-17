



let showData = ()=>{


    let dflex = document.createElement("div");
    dflex.className = "dflex"


    try {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        obj = JSON.parse(this.responseText);

        let userData = obj.data ;

         console.log(userData);

        userData.map((element,i)=>{

            let d = document.createElement("div")
            d.className = "box"
            

            var img = document.createElement("img");
            img.src = element.avatar;
            img.className="img"
            d.appendChild(img);
            let br = document.createElement("br")
            d.appendChild(br)

            var fname = document.createElement("fname");
            fname.className ="fname"
            fname.innerHTML = "FisrtName : " + " "+ element.first_name +"<br />"; 
            d.appendChild(fname);

            var last_name = document.createElement("lfname");
            last_name.className ="fname"
            last_name.innerHTML =   "LastName : " + element.last_name +"<br />";
            d.appendChild(last_name);


            var email = document.createElement("email");
            email.className="email"
            email.innerHTML = "Email : " + element.email + "<br/>";
            d.appendChild(email);

            dflex.appendChild(d)

            document.body.appendChild(dflex)


        })
    
      
    }
  };
  xhttp.open("GET", "https://reqres.in/api/users?", true);
  xhttp.send();


    } catch (error) {
        alert(error);
    }

}

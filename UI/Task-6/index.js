


const getData =async ()=>{
 await  fetch("https://reqres.in/api/users?page=1")
    .then(response => response.json())
    .then(data => {
     craeteTable(data.data);
     console.log(data.data);

    })
  } 


  let div = document.createElement("div");
        div.className="maindiv"


  const craeteTable = (data)=>{

    let table = document.createElement("table");
    table.className = "tbl"

    let tr = document.createElement("tr")

    let td1= document.createElement("td")
        td1.innerHTML = "ID";
        tr.appendChild(td1);

    let td2= document.createElement("td")
        td2.innerHTML = "First Name";
        tr.appendChild(td2);

    let td3 = document.createElement("td")
        td3.innerHTML = "Last Name" ;
        tr.appendChild(td3);

    let td4 = document.createElement("td") 
        td4.innerHTML = "Email" ;
        tr.appendChild(td4);

    let td5 = document.createElement("td")
        td5.innerHTML  = "Image Source"
        tr.appendChild(td5)

    let td6 = document.createElement("td")
        td6.innerHTML  = "Edit Data"
        tr.appendChild(td6)
        
    table.appendChild(tr)

    


    data.map((element,key)  =>{

        let no = element.id


        let tr = document.createElement("tr")
            tr.className = "tr" ;
            tr.id =key ; 



        let td1= document.createElement("td")
            td1.innerHTML = element.id
            td1.id = `id${no}`
            tr.appendChild(td1);


            let td2= document.createElement("td")
            td2.innerHTML = element.first_name
            td2.id = `fname${no}`
            tr.appendChild(td2);

            let td3= document.createElement("td")
            td3.innerHTML = element.last_name
            td3.id = `lname${no}`
            tr.appendChild(td3);

            let td4= document.createElement("td")
            td4.innerHTML = element.email
            td4.id = `email${no}`
            tr.appendChild(td4);

            let td5= document.createElement("td")
            td5.innerHTML = element.avatar
            td5.id = `avatar${no}`
            tr.appendChild(td5);




            let input1 = document.createElement("input");
            input1.id = `edit_button${no}`
            input1.value = "Edit";
            input1.type ="button"
            input1.className = "btn"
            input1.addEventListener("click",function edit_row() {

                document.getElementById("edit_button"+no).style.display="none";
                document.getElementById("save_button"+no).style.display="block";
                
                let name = document.getElementById(`fname${no}`);
                let id = document.getElementById(`id${no}`);
                let lanme = document.getElementById(`lname${no}`);
                let email = document.getElementById(`email${no}`);
                let pic = document.getElementById(`avatar${no}`)

                var name_data = name.innerHTML;
                var id_data = id.innerHTML ;
                let  last_name_data = lanme.innerHTML;
                let  email_data = email.innerHTML;
                let  pic_data = pic.innerHTML;



                id.innerHTML = "<input type='text' class='inputbox' id='ids"+no+"' value='"+id_data+"'>";  
                name.innerHTML = "<input type='text'  class='inputbox'  id='names"+no+"' value='"+name_data+"'>";   
                lanme.innerHTML = "<input type='text'  class='inputbox'  id='lnames"+no+"' value='"+last_name_data+"'>";  
                email.innerHTML = "<input type='text'   class='inputbox' id='emails"+no+"' value='"+email_data+"'>";  
                pic.innerHTML = "<input type='text'  class='inputbox' id='avatars"+no+"' value='"+pic_data+"'>";          
         
            })

            tr.appendChild(input1)
            let input2 = document.createElement("input");
            input2.id = "save_button"+no;
            input2.value = "Save";
            input2.type ="button";
            input2.className = "btn";

            input2.addEventListener("click",function save(){

                let ids =document.getElementById("ids"+no).value;

                let names =document.getElementById("names"+no).value;
            
                let lnames =document.getElementById("lnames"+no).value;
                let email =document.getElementById("emails"+no).value;
                let avatars =document.getElementById("avatars"+no).value;



                document.getElementById("id"+no).innerHTML = ids;
                document.getElementById("fname"+no).innerHTML = names;
                document.getElementById("lname"+no).innerHTML = lnames;
                document.getElementById("email"+no).innerHTML = email;
                document.getElementById("avatar"+no).innerHTML = avatars;

                document.getElementById("edit_button"+no).style.display="block";
                document.getElementById("save_button"+no).style.display="none";
               
            })
            tr.appendChild(input2)
            




        
    
        // let td2= document.createElement("td")
        //     td2.innerHTML = element.first_name
        //     tr.appendChild(td2);
    
        // let td3 = document.createElement("td")
        //     td3.innerHTML = element.last_name;
        //     tr.appendChild(td3);
    
        // let td4 = document.createElement("td") 
        //     td4.innerHTML = element.email
        //     tr.appendChild(td4);
    
        // let td5 = document.createElement("td")
        //     td5.innerHTML  = element.avatar;
        //     tr.appendChild(td5)

        
        // let td6 = document.createElement("td")


        // let btn = document.createElement("button");
        //     btn.className = "btn"
        //     btn.id = "btnid";
        //     btn.addEventListener("click",edit_row(key))
            
        //     btn.innerHTML  = "Edit Data"

        //     tr.appendChild(btn)

            table.appendChild(tr)
    
    })


    div.appendChild(table)
    document.body.appendChild(div);
      
  }



  const editData = (key)=>{
      console.log(key);

     let tr = document.getElementsByTagName("td")

    let btnid = document.getElementById("btnid");
         tr.contentEditable = "true";
  //  btnid.contentEditable = "false" 

  //   document.getElementsByTagName("tr").style.color="red"

  }




// function edit_row(key) {
   
// }


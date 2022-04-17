let obj =[ 
        {
         msg:"breakfast",
         status: false
       },
       {
         msg:"lunch",
         status: false
       },
       {
         msg:"dinner",
         status: false
       },
            
  ]




  window.onload = function() {
    header();
    displayData();
  };
  // document.onload = function() {
  //   console.log('document - onload'); // DOES NOT HAPPEN
  // };


const header = ()=>{
  var maindiv = document.createElement('div');
  maindiv.className = 'block';
  document.body.appendChild(maindiv);

    // adding heading h2 to div
    const heading = document.createElement("h2");
    heading.className = "heading"
    heading.innerText = "List of todo tasks : " 
    maindiv.appendChild(heading)
    // document.body.appendChild(heading);

    const span = document.createElement("span");
    span.id = "span"
    span.innerText =  obj.length; 
    heading.appendChild(span)

    

    const inp = document.createElement("input");
    inp.placeholder = "Title... " 
    inp.className= "inpbox"
    inp.id = "inpValue"
    // document.body.appendChild(inp);
    maindiv.appendChild(inp);

    const btn = document.createElement("button");
    btn.textContent = "Add Activity."
    btn.className = "btn"
    btn.type="submit";
    btn.addEventListener("click",createNewElement)
    maindiv.appendChild(btn)


}



  // localStorage.setItem("data", JSON.stringify(obj));


  // Creating main div

 

    // div from list and content

    // var cont = document.createElement('div');
    // cont.className = 'cont';
    // document.body.appendChild(cont);
  





  async  function createNewElement() {

      // var li = document.createElement("li");
      var inputValue = document.getElementById("inpValue").value;


      if(inputValue){

        var cont = document.createElement('div');
        cont.className = 'cont';
        document.body.appendChild(cont);

        const label  = document.createElement("label");
        label.innerHTML = inputValue;
        label.className = "labclass"

        const chkbox  = document.createElement("input");
        chkbox.type = "checkbox"


        chkbox.checked = false;
      
        chkbox.innerText = inputValue;


      


        cont.appendChild(chkbox);
        cont.appendChild(label)


        obj.push({
          msg:inputValue,
          status:false
        });

        

        let length = obj.length;

        console.log(length);
        span.innerText =  obj.length; 
        document.getElementById("inpValue").value = "";
        

      } else {
        alert("Plese Enter a Activity...")
      }

     
    }

    // <input type="checkbox" name="vehicle3" value="Boat">
  //   Object.keys(localStorage).forEach(function(key){
  //     console.log(localStorage.getItem(key));
  //  });

  //   let allObjects = localStorage.getItem("data");

  displayData = () =>{
    
    obj.map((i)=>{

      var cont = document.createElement('div');
      cont.className = 'cont';
      document.body.appendChild(cont);
    
  
      const label  = document.createElement("label");
      label.innerHTML = i.msg;
      label.className = "labclass"

      const chkbox  = document.createElement("input");
      chkbox.type = "checkbox"

      if((i.status === true ) || (i.msg ==='breakfast')) {
          chkbox.checked = true;
      } else {
          chkbox.checked = false;
      }

      chkbox.innerText = i.msg;
      cont.appendChild(chkbox);
      cont.appendChild(label)

      // document.body.appendChild(chkbox);
      // document.body.appendChild(label)

 })


  }


    

    // window.onload(printData());

    


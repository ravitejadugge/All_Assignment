import React ,{useState}from 'react'

function PostData() {

  const [firstname, setfirstname] = useState("")
  const [lastname, setlastname] = useState()
  const [city, setcity] = useState()
  const [jobTitle, setJobTitle] = useState()
  const [street, setStreet] = useState()
  const [state, setState] = useState()


  const sendData = async (e)=>{

    e.preventDefault();

    // let objData = {
    //   firstname:firstname,
    //   lastname:lastname,
    //   jobTitle : jobTitle,
    //   state :state,
    //   street :street,
    //   sisocode :city

    // }


    // console.log(objData);

    
      try {
      await fetch("http://corridor.cloud.wavemakeronline.com/EmployeesAPI/services/HRAPI/Employee",{
        method:"POST",
        mode:"no-cors",
        headers: {
          "Accept": "*/*",
          "Accept-Encoding":"gzip, deflate, br",
          "Connection":"keep-alive",
          "Content-type": "application/json",
        }, 
        

        body : JSON.stringify({
          firstname:firstname,
          lastname:lastname,
          jobTitle : jobTitle,
          state :state,
          street :street,
          sisocode :city
        }),
      })
        .then(response => response.json())
        .then(data => {
          setState(data)
         console.log(data);
        })
      } 
      catch (error) {
        console.log(error);
      }
    


  }




  return (

    <>
    
    <div className='mb-5'>

    <form className='m-3 mb-5' onSubmit={sendData}>
          
             <div className="row gx-3 m-3">


             <div className="col-md-4 m-2">
             <label className="small mb-1">First name</label>
              <input className="form-control" type="text" placeholder="Enter your first name" onChange={(e)=>setfirstname(e.target.value)} />
              </div>

            <div className="col-md-4 m-2">
              <label className="small mb-1">Last name</label>
              <input className="form-control"type="text" placeholder="Enter your last name"  onChange={(e)=>setlastname(e.target.value)} />
              </div>

              <div className="col-md-4 m-2">
              <label className="small mb-1" >City name</label>
              <input className="form-control" type="text" placeholder="Enter your last name" onChange={(e)=>setcity(e.target.value)} />
              </div>


              <div className="col-md-4 m-2">
              <label className="small mb-1" >jobTitle </label>
              <input className="form-control"  type="text" placeholder="Enter your JobTitle" onChange={(e)=>setJobTitle(e.target.value)} />
              </div>

              <div className="col-md-4 m-2">
              <label className="small mb-1" >Street </label>
              <input className="form-control" type="text" placeholder="Enter your Street"  onChange={(e)=>setStreet(e.target.value)} />
              </div>

              <div className="col-md-4 m-2">
              <label className="small mb-1" >State </label>
              <input className="form-control"  type="text" placeholder="Enter your State" onChange={(e)=>setState(e.target.value)} />
              </div>
              
              

             </div>

             <button className='btn btn-warning mx-auto mb-5'> Submit</button>


      </form>


    </div>
    
    
    
    
    </>
    
  )
}

export default PostData
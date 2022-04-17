import React ,{useState,useEffect}from 'react'

function GetData() {
 
    const [state,setState] = useState([])

    const getData = async()=>{
      try {
      await fetch("http://corridor.cloud.wavemakeronline.com/EmployeesAPI/services/HRAPI/Employee")
        .then(response => response.json())
        .then(data => {
          setState(data.content)
         console.log(data.content);
        })
      } 
      catch (error) {
        console.log(error);
      }
    }
    
  useEffect(() => {
    
    getData()
  
  }, [])
  
  
    return (
      <div className="App">
  
        
  
  
  
  
  
  
  <div className="container d-flex m-2 mx-auto">
  
    <div className='row p-'>
  
  {
  
    state.map((ele,key)=>{
      return [
  
  
  
        <div className=" gutters-sm m-3 " key={key}>
              <div className=" mb-3">
                <div className="card m-2  p-2">
                  <div className="card-body">
                    <div className="d-flex flex-column align-items-center text-center">
                      <img src={ele.picurl} alt="Admin" className="rounded-circle" width="150" />
                      <div className="mt-3">
                        <h4>{ele.firstname} { ele.lastname} </h4>
                        <p className="text-secondary mb-1">{ele.jobTitle}</p>
                        <p className="text-muted font-size-sm">{ele.street}, { ele.state}, {ele.sisocode}</p>
                       
                      </div>
                    </div>
                  </div>
                </div>
  
                </div>
        </div>
     
      ]
    })
  
  
      
  
  
  
  
  
  }
              
  
  
        </div>
        </div>
  
  
     
      </div>
    );
}

export default GetData
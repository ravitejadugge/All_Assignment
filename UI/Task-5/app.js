

//  "https://jsonplaceholder.typicode.com/users"

// "http://corridor.cloud.wavemakeronline.com/EmployeesAPI/services/HRAPI/Employee"


const getData = async()=>{
  try {
    fetch("http://corridor.cloud.wavemakeronline.com/EmployeesAPI/services/HRAPI/Employee
    ,{
      

    })
    .then(response => response.json())
    .then(json => {
     console.log(json);
    })
  } 
  catch (error) {
    console.log(error);
  }
}

import { useEffect, useLayoutEffect, useState } from 'react';
import './App.css';
import GetData from './GetData';
import PostData from './PostData';
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Link
} from "react-router-dom";

function App() {


  


  return (
    <div className="App">
       <Router>

      <div className=''>
        <ul className='row m-4'>
          <li className='m-3' >  
            <Link to="/getdata">GetData</Link>
          </li>
          <li className='m-3'>
            <Link to="/postdata">PostData</Link>
          </li>
        </ul>

        <hr />

      </div>

<Switch>

<Route path="/getdata"> <GetData /> </Route>
 <Route path="/postdata"> <PostData /></Route>

</Switch>



    </Router>


   
    </div>
  );
}

export default App;

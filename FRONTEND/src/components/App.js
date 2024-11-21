import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Register from './components/Register';
import Login from './components/Login';

function App() {
  return (
    <Router>
      <div className="App">
        {/* Navigation links (optional, you can style this as needed) */}
        <nav>
          <ul>
            <li><a href="/register">Register</a></li>
            <li><a href="/login">Login</a></li>
          </ul>
        </nav>

        {/* Defining Routes for Registration and Login */}
        <Switch>
          <Route path="/register" exact component={Register} />
          <Route path="/login" exact component={Login} />
          <Route path="/" exact render={() => <h2>Welcome! Please choose a page.</h2>} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;

import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";


import { useState } from "react";
import { useAuth } from "./contexts/AuthContext";
import Home from "./pages/home";


function App() {
  const { isAuthenticated } = useAuth();
  const [userRole, setUserRole] = useState<string | null>(null);
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Home />} />
      </Routes>
    </Router>
  );
}

export default App;
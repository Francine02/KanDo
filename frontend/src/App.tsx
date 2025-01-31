import { BrowserRouter, Route, Routes } from "react-router-dom"
import { Auth } from "./pages/Auth"
import Home from "./pages/Home"
import ProtectedRoute from "./components/auth/ProctedRoute";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Auth />} path="/" />
        <Route element={<ProtectedRoute />} >
          <Route element={<Home />} path="/home" />
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App

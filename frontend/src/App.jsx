import { BrowserRouter, Routes, Route } from "react-router-dom";
import Contracts from "./pages/Contracts";
import ContractForm from "./pages/ContractForm";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Contracts />} />
        <Route path="/create" element={<ContractForm />} />
        <Route path="/edit/:id" element={<ContractForm />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
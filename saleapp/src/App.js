import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'react-bootstrap';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Product from './components/Product';
import Footer from './layout/footer';
import Header from './layout/header';

const App = () => {
    return (
      <BrowserRouter>
        <Header />
        <Container>
          <Routes>
            <Route path='/' element={<Product />} />
          </Routes>
        </Container>
        <Footer />
      </BrowserRouter>
    );
  }

export default App;
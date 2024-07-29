import { useEffect, useState } from "react"
import APIs, { endpoints } from "../configs/APIs"
import { Button, Col, Container, Form, Nav, Navbar, NavDropdown, Row } from 'react-bootstrap';
import { Link} from "react-router-dom";
import { useNavigate} from "react-router"


const Header = () => {
    const [categories, setCategories] = useState([])
    const nav = useNavigate();
    const [kw, setKw] = useState("");

    const loadCates = async () => {
      try {
        let res = await APIs.get(endpoints['categories'])
        setCategories(res.data)
      } catch(ex) {
        console.info(ex)
      }
    }
  
    useEffect(() => {
      loadCates();
    }, [])

    const submit = (e) => {
      e.preventDefault();

      nav(`/?kw=${kw}`)
    }

    return (
        <>
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
            <Navbar.Brand href="#home">E-commerce Website</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto">
                <Link className="nav-link" to="/" >Trang chủ</Link>
                <NavDropdown title="Danh mục" id="basic-nav-dropdown">
                    {categories.map(c => {
                      const url = `/?cateId=${c.id}`;
                      return <Link to={url} className="dropdown-item" key={c.id} >{c.name}</Link>
                    })}
                </NavDropdown>
                </Nav>
            </Navbar.Collapse>

            <Form inline onSubmit={submit}>
                <Row>
                <Col xs="auto">
                <Form.Control type='text' placeholder='Tìm sản phẩm...' className='mr-sm-2' value={kw} onChange={e => setKw(e.target.value)} />
                </Col>
                <Col xs="auto">
                <Button type='submit'>Tìm</Button>
                </Col>
                </Row>
            </Form>
            </Container>
        </Navbar>
        </>
    );
}

export default Header;
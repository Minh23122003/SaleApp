
import { useEffect, useState } from "react";
import { Button, Card, Col, Row, Spinner } from "react-bootstrap";
import { useSearchParams } from "react-router-dom";
import APIs, { endpoints } from "../configs/APIs";

const Product = () => {
    const [products, setProducts] = useState(null);
    const [q] = useSearchParams();
   
    const [page, setPage] = useState(1);

    const loadProducts = async () => {
        try {
            let url = `${endpoints['products']}?page=${page}`;
            
            let cateId = q.get("cateId");
            if (cateId !== null){
                setPage(1)
                url = `${url}&cateId=${cateId}`
            }

            let k = q.get("kw");
            if (k !== null){
                setPage(1)
                url = `${url}&q=${k}`
            }

            let res = await APIs.get(url);

            console.info(res.data);

            if (page === 1)
                setProducts(res.data);
            else
                setProducts(current => [...current, ...res.data]); 

            console.info(products);
        } catch (ex) {
            console.error(ex);
        } 
    }

    useEffect(() => {    
        loadProducts();
    }, [page, q]);

    const loadMore = () => {
        setPage(page + 1);
    }

    if (products === null)
        return <Spinner animation="grow" variant="primary" />;

    return (
        <>
            <Row>
                {products.map(p => <Col key={p.id} md={3} xs={12}>
                    <Card>
                        <Card.Img variant="top" src={p.image} />
                        <Card.Body>
                            <Card.Title>{p.name}</Card.Title>
                            <Card.Text>{p.price.toLocaleString("en")} VNĐ</Card.Text>
                            <Button variant="danger" className="m-1">Đặt hàng</Button>
                            <Button variant="primary" className="m-1">Xem chi tiết</Button>
                        </Card.Body>
                    </Card>
                </Col>)}
                
            </Row>

            <div className="mt-2 text-center">
                <Button onClick={loadMore} variant="primary">Xem thêm</Button>
            </div>
        </>
    );
}

export default Product;
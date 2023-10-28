import React from "react";
import "./ProductCard.css";
import { useNavigate } from "react-router-dom";
import Button from "@mui/material/Button";

const ProductCard = ({ product }) => {
  const navigate = useNavigate();

  return (
    <div
      onClick={() => navigate(`/products/${product.id}`)}
      className="productCard border border-rounded w-[15rem] m-3 transition-all cursor-pointer "
    >
      <div className="h-[20rem]">
        <img
          className="h-full w-full object-cover object-left-top"
          src={product.imageUrl}
          alt=""
        />
      </div>

      <div className="textPart bg-white p-3">
        <div>
          <p className="font-bold opacity-60">{product.brand}</p>
          <p className="">{product.title}</p>
        </div>
        <div className="flex items-center space-x-2">
          <p className="font-semibold">💲{product.discountedPrice}</p>
          <p className="line-through opacity-50">💲{product.price}</p>
          <p className="text-green-600 font-semibold">
            {product.discountPercent + "%"}
          </p>
          <div className="relative pointer-events-none">
            <Button onClick={() => navigate("/")} className=" px-2 p-4 bg-red-600 pointer-events-auto">Add</Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;

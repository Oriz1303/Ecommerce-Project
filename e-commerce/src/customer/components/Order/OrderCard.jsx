import React from "react";
import Grid from "@mui/material/Grid";
import AdjustIcon from "@mui/icons-material/Adjust";
import { useNavigate } from "react-router-dom";

const OrderCard = () => {
  const navigate = useNavigate();

  return (
    <div onClick={() => navigate(`/account/order/${5}`)} className="p-5 shadow-md shadow-black hover:shadow-2xl border">
      <Grid container spacing={2} sx={{ justifyContent: "space-between" }}>
        <Grid item xs={6}>
          <div className="flex cursor-pointer">
            <img
              className="w-[5rem] h-[5rem] object-cover object-top"
              src="https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/27fd4c90-314f-4609-8f36-d7fca3b488f1/jordan-dri-fit-sport-golf-polo-pclvPv.png"
              alt=""
            />
            <div className="ml-5 space-y-2">
              <p className="">Men Shirt</p>
              <p className="opacity-50 text-xs font-semibold">Size: L</p>
              <p className="opacity-50 text-xs font-semibold">Color: Oriz</p>
            </div>
          </div>
        </Grid>

        <Grid item xs={2}>
          <p>💵 299</p>
        </Grid>

        <Grid item xs={4}>
          {true && (
            <div>
              <p>
                <AdjustIcon
                  sx={{ width: "15px", height: "15px" }}
                  className="text-green-600 mr-2 text-sm"
                />
                <span>Delivered On March</span>
              </p>
              <p className="text-xs">Ur item has been delivered</p>
            </div>
          )}
          {false && (
            <p>
              <span>Expected</span>
            </p>
          )}
        </Grid>
      </Grid>
    </div>
  );
};

export default OrderCard;

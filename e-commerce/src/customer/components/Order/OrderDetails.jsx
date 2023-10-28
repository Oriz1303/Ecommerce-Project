import React from "react";
import AddressCard from "../AddressCard/AddressCard";
import OrderTracker from "./OrderTracker";
import Grid from "@mui/material/Grid";
import { Box } from "@mui/material";
import { deepPurple } from "@mui/material/colors";
import StarBorderIcon from "@mui/icons-material/StarBorder";

const OrderDetails = () => {
  return (
    <div className="px-5 lg:px-24">
      <div>
        <h1 className="font-bold py-7 text-lg">Dilivery Address</h1>
        <AddressCard />
      </div>

      <div className="py-20">
        <OrderTracker activeStep={3} />
      </div>

      <Grid container className="space-y-5 " >
        {[1, 1, 1, 1].map((item) => (
          <Grid
            item
            container
            className="shadow-xl rounded-md p-5 border "
            sx={{ alignItems: "center", justifyContent: "space-between" }}
          >
            <Grid item xs={6}>
              <div className=" flex items-center space-x-4">
                <img
                  className="w-[5rem] h-[5rem] object-cover object-top"
                  src="https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/27fd4c90-314f-4609-8f36-d7fca3b488f1/jordan-dri-fit-sport-golf-polo-pclvPv.png"
                  alt=""
                />
                <div className="space-y-2 ml-5">
                  <p className="font-semibold">Men Shirt Nike </p>
                  <p className="space-x-5 opacity-60 text-xs font-semibold">
                    <span>Color: Black</span>
                    <span>Size: M</span>
                  </p>
                  <p>Seller: Oriz</p>
                  <p>$199</p>
                </div>
              </div>
            </Grid>

            <Grid>
              <Box sx={{ color: deepPurple[500] }}>
                <StarBorderIcon sx={{ fontSize: "2rem" }} className="px-2" />
                <span>Rate & Review</span>
              </Box>
            </Grid>
          </Grid>
        ))}
      </Grid>
    </div>
  );
};

export default OrderDetails;

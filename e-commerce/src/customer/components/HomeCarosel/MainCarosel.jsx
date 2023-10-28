import React from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import { mainCaroselData } from './MainCaroselData';


const MainCarosel = () => {
    const items = mainCaroselData.map((item) =>
        <img className='cursor-pointerx w-full h-full object-cover object-center' role='presentation' src={item.image} alt="" />
    );
  
    return (
        <AliceCarousel
            items={items}
            disableButtonsControls // remove btn previous and next
            autoPlay
            autoPlayInterval={1000}
            infinite
        />
    )
}

export default MainCarosel
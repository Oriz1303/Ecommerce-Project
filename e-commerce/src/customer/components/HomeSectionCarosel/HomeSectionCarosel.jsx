import React, { useState } from 'react'
import HomeSectionCard from '../HomeSectionCard/HomeSectionCard';
import AliceCarousel from 'react-alice-carousel';
import { Button, makeStyles } from '@mui/material';
import ArrowLeftIcon from '@mui/icons-material/ArrowLeft';


const HomeSectionCarosel = ({data , sectionName}) => {
    const [activeIndex, setActiveIndex] = useState(0);

    const responsive = {
        0: { items: 1 },
        720: { items: 3 },
        1024: { items: 5.5 }

    };

    const slidePrev = () => setActiveIndex(activeIndex - 1);
    const slideNext = () => setActiveIndex(activeIndex + 1);

    const syncActiveIndex = ({ item }) => setActiveIndex(item);

    const items = data.slice(0, 10).map((item) =>
        <HomeSectionCard product={item} />
    )

    return (
        <div className='border' >
            <h2 className='text-2xl font-extrabold text-gray-800'>{sectionName}</h2>
            <div className='relative p-5 '>
                <AliceCarousel
                    items={items}
                    disableButtonsControls // remove btn previous and next
                    // infinite
                    responsive={responsive}
                    disableDotsControls
                    onSlideChange={syncActiveIndex}
                    activeIndex={activeIndex}
                />

                {activeIndex !== items.length - 5 &&
                    <Button variant='contained'
                        onClick={slideNext}
                        className='z-50 bg-white' sx={{
                            position: 'absolute',
                            top: "8rem",
                            right: "0rem",
                            transform: "translateX(50%) rotate(90deg)",
                            bgcolor: "white"
                        }} aria-label='next'>
                        <ArrowLeftIcon sx={{ transform: "rotate(90deg)", color: "black" }} />
                    </Button>
                }

           
                {activeIndex !== 0 &&
                    <Button variant='contained'
                        onClick={slidePrev}
                        className='z-50 bg-white' sx={{
                            position: 'absolute',
                            top: "8rem",
                            left: "0rem",
                            transform: "translateX(-50%) rotate(-90deg)",
                            bgcolor: "white"
                        }} aria-label='next'>
                        <ArrowLeftIcon sx={{ transform: "rotate(90deg)", color: "black" }} />
                    </Button>
                }
            </div>
        </div >
    )
}

export default HomeSectionCarosel
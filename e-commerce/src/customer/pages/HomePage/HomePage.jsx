import React from 'react'
import MainCarosel from '../../components/HomeCarosel/MainCarosel'
import HomeSectionCarosel from '../../components/HomeSectionCarosel/HomeSectionCarosel'
import { mens_shirt } from '../../../Data/mens_shirt'

const HomePage = () => {
  return (
    <div>
        <MainCarosel/>
        <div>
          
          
        </div>
        <div className='space-y-10 py-20 flex flex-col justify-center px-5 lg:px-10'>
          <HomeSectionCarosel data={mens_shirt} sectionName={"Men T-Shirt"}/>
          <HomeSectionCarosel data={mens_shirt} sectionName={"Men T-Shoes"}/>
          <HomeSectionCarosel data={mens_shirt} sectionName={"Men T-Pant"}/>
          <HomeSectionCarosel data={mens_shirt} sectionName={"Men Hat"}/>
          <HomeSectionCarosel data={mens_shirt} sectionName={"Men 2"}/>
          
        </div>
    </div>
  )
}


export default HomePage
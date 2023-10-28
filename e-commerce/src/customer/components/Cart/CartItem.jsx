import React from 'react'
import IconButton from '@mui/material/IconButton'
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
import Button from '@mui/material/Button'
import { useDispatch } from 'react-redux';
import { removeCartItem, updateCartItem } from '../../../State/Cart/Action';

const CartItem = ({item}) => {

    const dispatch = useDispatch();
    const handleUpdateCartItem = (num) => {
        const data = {data: {quantity: item.quantity + num}, cartItemId: item?.id}
        dispatch(updateCartItem(data));
    }

    const handleRemoveCartItem = () => {
        dispatch(removeCartItem(item.id));
    }

    return (
        // box item checkout
        <div className='p-5 shadow border rounded-md'>

            {/* product card info */}
            <div className='flex items-center'>
                <div className='w-[5rem] h-[5rem] lg:w-[9rem] lg:h-[9rem]'>
                    <img src={item.product?.imageUrl}
                        className='w-full h-full object-cover object-top'
                        alt="" />
                </div>
                <div className='ml-5 space-y-1'>
                    <p className='font-semibold'>{item.product.title}</p>
                    <p className='opacity-70'>Size {item.size} { /*, {item.color}*/ }</p>
                    <p className='opacity-70 mt-2'>Seller: Oriz </p>
                    <div className='flex space-x-5 items-center text-gray-900 pt-6 '>
                        <p className='font-semibold'>${item.discountedPrice}</p>
                        <p className='opacity-50 line-through'>${item.price}</p>
                        <p className='text-green-500 font-semibold'>{item.product.discountPercent}% OFF</p>
                    </div>
                </div>
            </div>

            {/* button add or remove product */}
            <div className='lg:flex items-center lg:space-x-10 pt-4'>
                <div className='flex items-center space-x-2 '>
                    <IconButton onClick={() => handleUpdateCartItem(-1) } disabled = {item.quantity <= 1} sx={{ color: "red" }}>
                        <RemoveCircleOutlineIcon />
                    </IconButton>
                    <span className='py-1 px-7 border rounded-sm'>{item.quantity}</span>
                    <IconButton onClick={() => handleUpdateCartItem(1)}  sx={{ color: "purple" }}>
                        <AddCircleOutlineIcon />
                    </IconButton>

                </div>

                <div>
                    <Button onClick={handleRemoveCartItem} sx={{ color: "purple" }}>Remove</Button>
                </div>
            </div>
        </div>
    )
}

export default CartItem
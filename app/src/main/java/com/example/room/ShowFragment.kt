package com.example.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.databinding.FragmentShowBinding
import com.example.room.viewmodel.MainViewmodel

class ShowFragment : Fragment() {
    private lateinit var binding:FragmentShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         binding = FragmentShowBinding.inflate(inflater)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = Adatper()
        val recycle = binding.rcView
        recycle.layoutManager = LinearLayoutManager(context)
        recycle.adapter = adapter

        val name = binding.name
        val price = binding.price
        val btn = binding.add

        val viewModel = ViewModelProvider(this)[MainViewmodel::class.java]
        viewModel.getPizzaList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.list()

        btn.setOnClickListener {
            viewModel.insertNewData(name.text.toString(),price.text.toString(),"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUTExMVFhUXFxgYGBcVGB0aHhkdICEbGhghGhcbISghIB4lGx0aIjEhJSorMC4uGR8zODMtNygxLisBCgoKDg0OGxAQGzcmICUvKy8vMDAtLTUvLS0yLy0rLzA1LTAvLzA1LS0tLy01Li0tLTUuLy81Ly0tLzAtLy0tL//AABEIAOMA3gMBIgACEQEDEQH/xAAcAAEAAwEBAQEBAAAAAAAAAAAABAUGAwcCAQj/xABHEAACAQIEAwYDBQYDBgQHAAABAhEAAwQSITEFQVEGEyJhcYEykaFCUrHR8AcUI2JywTOi8RVDgpKy4WNz0uIWFyREVJPC/8QAGgEAAgMBAQAAAAAAAAAAAAAAAAQCAwUBBv/EADMRAAEDAgQEBQQCAgIDAAAAAAEAAhEDIQQxQVESYYHwE3GRobEFwdHxIuEUMkJSIzOC/9oADAMBAAIRAxEAPwD3GlKUISlKUISlKUISlKUISlKUISlKUISlK+GYASdB50EwhfdK42r6sSFIJG8V2rgIIkLpEZpSlK6uJSlKEJSlKEJSlKEJSlKEJSlKEJSlKEJSlKEJSlKEJSlKEJSlKEJSlKEJVRxrEBcoJgb7b1b1yv2QylTsRFUYmk6rSLGmO8uveyspPDHglYrG4hQwdJkbsCQfKr3szi7lxWz6qD4Sd9dSPb+9B2bT75+Qq0wODW0gRdh9fWszBYGtSrcbrC9rXPd5zkC6dxOIpPp8Lbn4UmlK5XklSAYJBE9K2lnKLc4mg5MR94RHtJBrvh8Uj/CfONjXk/Ae3zYNv3PiVg5rXgF1VkkDQFlPxKRBDruOXOtXb7U8MZe8t4lVG8QykegIkGpEK51Fw09Lra0qNgbpe2jGZZQdRB1E6jkfKpNRVKUpShCUpShCUpShCUpShCUpShCUpShCUpShCUpShCUpShCUpShCVye4ogEgFjAkxJgmB1MAn2NfbMAJJgDmaqcJj7F64UDLcKHOhImDqpKEjlmjMOTxUXPa0gE3OXyuEwrilKiY/GpZttcuNlVRJP5VImLlSAJMBcOLcEw+KXLiLKXQNsw1H9Lbj2NVGA7AcOsuHTDDMDIzu7gHl4XYj6VP7N8bXFo7qIyvljnEAqToN9auq41/EJGSscKlJxY6x1CUpSuqpKUpQhKUpQhKUpQhKUpQhKUpQhKUpQhKUpQhKUqi7UcWNi2Qkd6wOWeQG5/IczUXvDG8RU6dN1RwY3MqZxLjNiwJu3VTSYJ1/wCUa1+YDjGHvHLauqzZQ0DeDqDBryoWjdcuc/fsRlB2zMQJzEkmU6/2FXPZnD5sfYuKCpVXLRopAVkkDnLH20pJuLc54EWK2Kn0umymSXGQCdIynLO+QMr06lKjY98tq4eiMfoafWIvNO1Hao4m/wBxaJFhD4iD/iHmSfuDkOe/p9YLFZMTYKE6XQp9CVV/mH+lZfA8Na22ozCJJMBQeU6ydeVbrsbwo3LgvMp7tIKltM77Ar1AGubaYiYNecDKtfEh53HQAz3+VnU3Oe6+ZXoFeddoFu3sUGNrEtbUFVUWWygzvzB6yRy02mvRaVv1afGIlbWGxHgOLgJMQvNOG4h8G85vAA023y2yRJkAGc0EHY6e+t7d7azlNrDs6tsxuKg95294qm7a8Ou27j3FUPZuMHMmcjRDAAwADGaJ1LEVl8FxMgsuaYgBB1bQzHh5bieWxpDjfSJYCtvwKWJa2qQCSOY6GNR2V6pwrjyXWKFWt3B9lgYPPwvADaQau68evtetMioYuErlRQW8QIy5cpJnQyCBEnXevX0mBO/OnKFQvBnRZONwzaJBYbH7fY6dbr6pSlXpFKUpQhKUpQhKUpQhKUpQhKUpQhKUpQhK8/7b4InFW3NwgC2PCNTAYzkSfEZInyivQKpe0HBFxKAZilxZyXF3WYkehgT6DpVNemXsgJvA1xRrBzjAyPffVecYS6oxCQGa0CQGueHdSupBjTxc9+laHstibNvEyx1e3ktuToASGyknmSPmp6is3xfsxjLJH8J7wBHit6+EHWQCSdzpA2nSpuE4Jibqk91d7ydA6tbVddDLwZjoTp12rPYHNcLX8u/Zb1Y0qlM/zsREyOn9m05L1eo+LsC4jodmVlPuIqH2ewl21YS3ecO6zJBLaSSozNqYECT0qa9kFlfWVBA1MaxMrsdhvtWrmF5hwAJAM891nuC9h8Lh4JVrrj7V05vknwj1ifOtRSqHiPanDWpGfOw0It6wehPwg+Uz5VWTTot0aPRdoYdzzwUmz5Dv3V9SsjZ7a2y0G3p5NJ9lKgfWtJg8Ul1A6GVbY/QyORB0IrlKvTq/6GVbXwlahBqNie9PupDKDodRVRc7L4RmzHD2w3VRl/6Yq5pVpaDmFSx7mXaY8lDwfD7VoRbtqukaDWPM7mplKp+PY42woUkFjy+W/wA6pr1mYemXuyGykxjqr41KuKVk+B8Sud6UuM5liIPLpvr8q1lRwmKbiWcbRF4gqVegaLuEpSlKZVKUpShCUpShCUpShCUpShCUpShCUqn45xNrJQKJLGPy30qLiOJsozTJEGJGvtSFb6jSpPcwzLc7cp622TDMK94BGuXwtFSvwV+0+l0pSvw0IXn/AGr7Rs7NZtMQgJQkaF2BhtfuDbz85ANUeGMpEkeF1KsPtKN/D130qDcsXLL5GGtswQROo5xuQRqDrIipN7GNcOePuwM0AAagnmAWAnnAivM1apqPLn5/HLzC9vToig0U6McO9r7HTMSdRHRdOJIAwAtxJGVRAk7+Z/AVsuxU93e6G8xH/Kn6+dZXhHDXxNwhNpPeXY8Kg/ZtzuYNeiYDBpZtrbtiFUaefUk8yTqTT306i7iNTIdhZf1as1lIUM3WnlF5PM+puTopdKVwu4hFIDMqltgSBPpO9a5MLzgEr9s3VYSrBhJEgyJBgiRzBBHtWX4/iLgvqGWE6kTprEHr+daexaVRCBQJJhQAJJknTmSSfeu1LYzCnEU+Di4bzlI6iRIV1CsKTuKJWa7OcOk/vDkzLZRyHIn8RWmr8pXcLhm4ekKbep3Op6rlasary4/pftKUplVJSlKEJSlKEJSlKEJSlKEJSlKEKp45gC65lkuogDrVDhez94mSFH9R/Ka2lQn4jaH2x7a1nYn6fh6j/FqW6gA+v5Cco4uqxvAwT0ldsMpVFBMkCCeprvVVc4yg2Vj8hXA8cPNAP+L/ALVd/l0GCOL5Pv8A2qxhqrrx8flWa953hnJ3eVYic2aWzTyyxljnM1JqgbjZAzEIF3LToBzM+VVtvil06m4x0Gw05zroN408xUH/AFCk0gCTO3TeN7KbcFUIJMCFfcT4PZvj+IgJGgYaMPRhrHltVbh+xeFVsxVn5w7SPkIn3mqk9oHnKGfN0YldOW/Xl1qZax96YzHaZ7wH++3nSzsdh3Pl1MzzanKdPFU6fDTqwOR/tam1bCgKoAA0AAgD0Ar8v3MonKzagQu+pA59N/QVnbfGLonnG+xHlqBpXRO00TmWTrAEyY+dMN+o0HQJgnkkzga2glX2JvZFLQSQNFG5PICsJxriwW63eXIYcmUwo5CQTpvy/vFDxjtTiu9LpdlBOaV8NsHkAIkAx8Unz1io/C+Mrfu2xeLsjvLZSRHQlFEHWCdNI3pPGVhXIbePbr2Y6rawv0mtRa6oYMC8ZxmbGNMriclcrx/xCBI0Mg8t5jzq84Tx4/fJHQ61DXAYS4bsQwAAZohjr4YfQkzzH1qnv4buM0yVVvCwnxawZE7jrtpScPoGWOnr+OvpGaoZUp4lolua9LweOW55Hof7damV53hOJERG/LU++1avgvFO8GV9HH1H5/r018Jj21oac/n+/lIYnBOpDibl8f0rmlKVoJBKUpQhKUpQhKUpQhKUrJ8d7Td3d7i3oSJ7w6jzCciRp13iqa9dlBnG8277+VdRoPrO4WLR4rGJbEuwHQcz6Dc1T4rjTnS0oXo1zX6D86pbFwM2Z3Lsee/629qquLYhrTMq5gLjZVbmFglo5ydp6D3rJqfUKjxxNED39fsI88lqUPpzC7gJk87DvuFN4vxrdcxuvMQx8APqDqfJQPWqPvLtxyNCQA2WABr91doGnU198Lw4uXCpEoEgREqeRnk3kNNKmYXIjEh9QjLmPQRm25gkfOkYLzxH11tncyftyW40MoNLGC4E5fjLp7qPg8Q9vMcsFB4gugIGhDAHRo2P6OsthMole9nUKCI5/ETy1isXcaM0SQQQoA3+82Xp5netZ2fsNhhFxSLb5Yc7g7eMcp9PWrcOAJM3GtrA6xBtzI55JX6kwFodrt/2y5zI2F9F0u2VfD3kKkZbb6KdASpjkBofwqXjLzWbRyJmRVYsweChifh5/rav3HYIAXHBPjV1LFtIYECeWUEgjTT3NZzFSrW79xItXMuYKzqVbKAzmORAEmeQ6SW3ksBEwd7ZTnkbZDfUalZdBjKrhOW252zF84m05hfuHxlu7cJe2rG6VRz95SfOCuuupOp03q9Is25TMgUqZEqITaCZ0A2may/FODYtrpGHxWI7uBHxMRM6EqQOvKviz2GxJcXLuIRjvDqWExGynUjzrlMOE6mT+u/RP1MPhHAHxQwRlBN/jvNafiNu0tjPE2pAK2hnYmYEGdTtzEedZnjXDnYtczPbtxE3ZJgD+VSAOWvzq84XiRbtixbGd5ZoAHiK6FiAIVZED0G9RsW4v+MOBdTMnjWUnmrI2hEjff61XVNMtE5EDvPKDYDcnKEvQc+m5xZeCb8iQBpaYzM/KpOPYa1awgs2blpzcuAu0iYEzpvC/FHODXLhGFRUACgHwk8yQWyiSOoB8qk8dwFs4dLiILea6ucBQAIIZspXQpIB8644d1WNTACjlsohefqfelqz+EgNyjosf6pi6jneCXHhzIOridYiYAAEq44LcCPcBkkgFVA+IrLDfbyqP+6viv4iTaZfhDg7Dy0IE8/p0qMdjL6+KzMt5sCR6j8PSotjjuNVgGAKyJMzMbatr6896tF2gwYEnSDeRne3981qfS8JU/x2uBAmYmZiTta/wrW2pQnYgETlO2YZhy9dp25VbWuIhIcuqlTprt6+Xl51Q8T7U2sQhyZc6KFdQdjIiDz2PUjUGqXC4S5fuBEVrlw7BeXXXYDzMUuaRZVIp65fIt3e6abUln/kFxINx5Zr3LAYpbltXXZhP5/WpNUvZThLYbDLadszSWaNgTyWeQ289Tzq6r1FPiLBxZxfzXnagaHHhy08kpSlTUEpSlCEqt4lxRLIg6tyUfSTyH61rlxrifcrlWO8b4R0HNiPL6mqXC4UzmYzmPxMRJ66E6n0pDFYssPh07u11jv+9k7h8MHN8SploN/6910vYm9d+I5V+6BAj+/v9Krb4RlPeW0yrOtw+R8Q8v5gdNPSuXaXjD6WrYNtNQW5zpMiCcoGum871RYW1l8RHejKBcbUMAxMqCTJEAwCOZ8qR4JfLzxeffwFqU8OX0wQeEaAdjPmSVLGJzNdFsqGAWSLfwrlG7CC3iG5JiN6sOH30uutm+8EpmynUsJgHMdV1H0rK4qwlm6GOYjKDkJhypM5VjUSux5nca1rsT3bnDlH0AVbVsGWEmJZM0dJBkxPnUfDAM9m+WeXW5zkWV9Wm0EBozkyNDHzzyAvMiVXYrh4t3JsXBObKqlgHOu4jw9dZA8q74Ts7iHOXJlA0PeOuX/ISzDnGgJ3q6v9ncP3itGW8JctbkLoZ1UyNZ8ietVd+7eTPddA9tCFzg7DRQcjQdegnUnWqqlJtOZE3yBg7m3KRlyuuN+oVHwGC+5E30iCM9Jv6rrhMG+FdySXuMuUyqwBMyByGg+VRbXaDFF8gRbnUGCGHqIK6H/sa+8BxPCxcuBJvELmzBT8IgHMTyG8+Q2rR8OxKHvVW5aYbqBsoOwLbGTzq5nC+A0xF7GdPTTUKNV7mcTq1KTlcRlG2kHccjKjY+0VSVsrlgwC7TOoICzrp89Kg3uHC6g/eLj3JUKLaKTlOWN46k66aweQrIX+2vEkXu3wZa4ohotXRrtJ3B15jTpXI9qeJ6I2Gt2GZZDMhDR1Ado6fZp04KlTMvdAtq0AR5EE9QUlSdXeeGmATfK5I945wtbwnirWsORiCEymMmrMRCQSOvPTYVoeHqtxVcMWBWW2IIMwJA19ug61g+znZ7EXlJvuSGJd3eSXJMwD0g7+kDprbHDrOFtwuJZFEmGZTB5wu45+EUmzMnMDI8gbGDFunzKbxTKZs13/AJDmAJFxcW1B8/OykcH4WmFGVdSxJLkakE6At9BVfisNbsXrguBTZu66kgz0mfXToapeIdobiK727zlXBS3OrToxbKBAA25zNU1vtddcquJtpehgcrAaebRGkdai6q0tIi8+Y/u3L4C5SwjmA1C8QbG5k62tmCvQeIWsKloMwtppK6BpPKI/tWVtcVwgB72yAdf4mdo1nYa6gRoJ9qi8b4+t9MmVUWQTrtGu52G1UGK4uiQChOkryBneD/rVTqviPlonoL+v2A9lS3B0fBPGyTnNob6XPuJVwnFok24vSRGcchttHL0+lQH4dexZAEKobK2UwBO+ZiZI1mJ9qqP9vyfhAHQDT3q0wfaZtBB02qTKTrcZnvfvor6mJLpE59B6LZdn/wBl9m0wuXHDT4iqDTzGc6lTA2C16BYsKihUUKoEBVEAegFef9me1uUhLmts9NSnmOo6j/Q72/i7aKGd0VTsWYAHmIJ8q2cOafDLLb/srExAqcQDr7foKTSoeH4hacwlxGOugYTp5dPOplMAgiQqC0gwRCUpSuriVzdwASdABJNdKpO0mJK2wi73CRp90fFH0HuahUeGMLjop02F7w0aqgu3O9uPdbTXQHko0UeXX3qgxF2934vM6+HMEQMRlGkAggSWGs/TpfYBrLhlJEBspBPMTGsjn89TVF/sRg7u1wd2JMrlzE76a6A15sOcZIAl2t/OeX2jyXo6baZqDjcWhuQix0jvMWXJ5JuXXuMBcl0GUsSxmV02iYnSZFdOG4he7ZXhWzFuZjQBSQNMo+H3O1RMbbAjubghzMRJJUCcxkQIjaIM1w4Vw++S7BFKKytlnfSF0VTz3GgE8t6ba8AXPvyumajREnK3LkB9rm52lWVnFqM6FVl1HjkBk38SsxA03nbbc04NdyFhZV+8DZ85EsV0MiRpIjTSddNalYjgSvdVLlwhdMy27MhJjQQTlk6zAHWeelw1juIFi0gllzmG0TTMc5OrRy+lTcIz77380oMVTuG3J0yb1J+MlW4e1jLynKSqkSHuAD5AGCfUVa8Z4B+8WBaD93GUk5RBIGXUfkd4rJX+PXHuOSSig3FIXRlAMgE6cz9DV3wril5gMzZlDooOUAwQ2Us08yANfvVXTrscOFwJm2Y7G+9rqVfC4im4VW8LSCDAGum4PsNs70WE7N27WIVTfDPDSCvgyiMwMkyDMEaTmIq/TgltCxsPOYjwupyqBy6kRy15V9viMrAKZLNs24PzBGvPb05W13hGaCbhg/ZUZZ9SSTUfDJ/9bZ5ybab59CeSpq46s4jxX9IF+gH3HysXj7TNcK2xdzgT3YJK5NRIadBoYJjaJnSpHDGZ2ZSbd5LbMASuYEbHK3IEDlpV72owlpMK3hIIUqpWTlnQk+2pPlWZ4DZusuzBAFAcAA7eEwNdNRJGwPpUHt8J7ZEzEgW/GW8ZDqnKVYVsMX5AGBPT1sbDPmRloxxt5YBbcJ99gDPsCfpyqNwxLWIzM3hZzsiJKFv54J3B1PWPKsnjLjpNwqxVTHeZkHiE6CWDfCeQ1k6V34R2kt2SXKXNSSGSCCOYYCD+dQGJc94BEg7nfyGcae64cCBTPhQDyPsZOvktPe7OW8Oq3reZntkEsxklSfFIAAPWY61XdoL3ePbdQxUP4nUEqARENpB1g19//MrDjdWnzER+NaTgXFbeMw5uZdCzDKTyB0/XWadDGkFjSBOkai+f7O3JMMxGEYKlWnYGJka6d23UTFcFw13DOzWg+hYoy7Eaxl9YrFYXht2/bCHCuU/pIgnaCRppoSOntXo+H4Ylol87gQfCWAUT+McpOnKqbG4hkuZ7N8FogoSGUwWgECCDBAza7DTSaMTTkguMeWZ5rmExUFzWjimCCZtY2tO+eSxWJ7FgHIALTnVQxlvYZiT8q64DsGWUK7kMJzZWEqJ00giPafOrbFYvD37wOMR7V0Qsq7BTzHwnYEHz1+VjgeIksbdoO58OSVMgcy7Hl67j1qqmA3+UyPfy3n7+qliDVa0NLQ2dQLeuUfCxl7sy9q4uY3Ag1guNYOnw79Rp+VXWGZruTMzG2qg2wZgBtZAIGuu5/tWh4l2ehGYFRmJa5AzEzqYDZuc8vzqvw+GVQEVcoHhG/i8/QaCNt/anF03hhB1PqO+XLOJjQqse4EG/lH5v1yXzdsQAy6MNQRyI1ER+vOt9hL+e2jj7Sq3zE1h+ILCTJAAOx5EfXYVs+DCMPZHS1bH+UU39MHC5zRsD1ulvqV2tJ3Km0pSthZSVlO11zxougAViTOupWIH/AA/h5xq6xvbdMt3D3eUOh9dGT8GpP6gCcM+Nk3gY/wAhs8/grPcSwd1UYWLiqbkyH2E/aUMCOZ94rla4Ncsj+I4vHLJGsDUbAnU6jpzrRYbK1szoYMHoRME69eVZ7ifG2snu2ds7jNmOUEL5wCfFGmoPOsOiGBpLvMax0/FluUvGfWAp568/TZRv9npecNatvA0cSRnaCNSx0UdBv51fdluD3LF3/DGTu2XV5iSpgCddhv08tM5gr1sMxRnN1iIg5RrI8QGnTU+dekcEDC0vewHGhOm86babRTOHe2rUyyvOX2tyUvqJfQpcIyMi8zfOL5dAuDXyzAoi90yls2aDPhyjLGoKySZ0iOdfeCxUFszSIJiJOnp5VExli9bARVR12BLZCB5jWQBzFfOGw6tbIVkLmC2TUBZBidyDEeetcaavjAnS5/Qzt7XWXwU+A3sT6fj2VBxa7aF1WYrcR3kJlK3FO8IV8Q5aA66aV+8b48AlqxYS0M91QVRdQFMmRyAIg8xV5xBv3e7aL2bbWgp8ZSWDSToxJjTLpuddahcSxVlj3hu92TJT+ESYiNGOv4+VWnhZxNLr87HIb6dfwtOnUNTghhIFxqJm1mtzGsiVZr2gsBVVokCCSJGmmpjy6VZveK2xcVlcbnUGR/KwgaVgHvq/8O3LNEmVIAHuBVv2ftzYu4d2hWGh5jmYEen6Fd8YkkzNjGl/v5/lUVsBTYziFriQbyN9+nurm7xqyAwLXNjJO8HoCII9Kq8HjrDN3S27a6EjL4gRzVkBEEiPFWfThajECyLhRiJzHUFZIMjKpBOh36+1xwTili2oKoB/DYl20gKJ1B1k5T02pXx6pcOOAPLLl5zHI76K6phqVJpFOXEiRp18s91Lxlm3YUWldUD+NwxMED7syf8AXfSstfw+FuXXuIlyYnwTleBqAwBAP+mlfXGrty9cm4AwbUZNSojRVnQCdCI8+dfGEw1tmtqjMgyuWM6tl8RMTExAgUxYjhjp9tfPqrKdHgaC8ydfm+pyj4tdV1/hlq9nSB3kEKtxWUz01GUtIgTJ11GtdsI18ZA3xp4Fa6WOUTqNQRMxrGmUAHlU7GW3uLqc9wvpm+ETIadJnbyqRbW4lpkv2Hu9yxLsknJ9qDOsZT12g1Q6kQP4m21/tcd6KTGsbU4tf/n1vEjSDuqe3xvEFioV7iA/4kHKf6c5ltZ2HntWgsYtgCroLdwrmhlKlR5gmNtNDXPh3aLCXLitNsMo8MjJrz1Gk66TtHnUntBisPiUeznK3k8SsAGAkCQHEgqRy29KtADZIdH3/HKx91KsanEGmkYzJi40yESBvrlonEON2msCx3feiTOeI3nQLy6ENNfPZq+PFbt3GUgaI9wlN4IWdR6EnyjnlF4j3SeOQywA0ayDPMx6NzAHrWw7NcNAti+wBiSC0gACdcux9520pek6q94MyNfL0OXX0lSr06VHDujU6HN3kbfBVjh+PpcEKv8AEUsHzGPh0bT7WvMV8WTJYtEnl06VAsWrRuNdCrnaSWyhZneBymNZ11+Xa/jAqzMEE7e41PI6fT3HH1BUcHT/ABGXxPnCQbSDZAEE9+k/bVfGIurdupaUzmuBCIjSfF7ZfmBXocVgewvDe8vviyDlWUt9CftsPQeHzJbpW/rY+nUyKZe7N1+miy8fUBqcDcm/OqUpSn0ilZzt4v8A9E7je2UuDyhgG/ylq0dRsbhlu23tt8Lqyn0IioVG8bS3cFTpv4Hh2xXnfBMZmIKxHn9anYvgVu6sG2pWIAygkADSNZAHIRpWE4Xjmw102bg+FivoQSCNdNDPt61vcFxXMysgB3knQTtp+udeXpDwSWu3yv1y22/tehqzUh9PbNQcBw63hbn8K0XvKPRV0kcwOh6yKseD4+81x89xFIhQh1UGOeU7+/SrK5igfFlJ6+Jj/l/vWXvcNvW8Q2ItEtaJDtBHgCgzpznrTkPaA5lxOQnL0mesGFQKwe4tqZxm65nlMwOUKZjmv2rzvd/iIyKHyPOQCRIskzE8wJkT6dOG3hYc3VVrlsJEgRoYK6jcZoHM7aRXPiXEEuXVuW75tEiC1zKwMagBU0jX4tfrVPY461/MGZ7hU6KAPCdRqE20Mg1Nz2AmDrY5/wB+0bapxrC6l/IACAHZj0GXUERtvveLcWW3Z75iASmZA20xMGJrI8T7d5rUC3mY81mB1iefnr9KkXLVzEYUJcAUKYtiCGiJOvKI+lZqxhbmH0IOQmEY6KDvB6nmPKqsRiKky2QD779Z5C0LExrTh6U0uEkOPEYkt/6xfh4d5Bg+1YnGX7zvURkMAaEN/wDzvHzr0PsXi7TW3bOWu+EXM/xDpHLIeUaVi79wAkOiEmdgV38xp9DrrXbh+KWywdZWN9iCJMAz1McutLUq4Y8GO9/OEhhsZiqtVtJzy4OIEW3+BmdOS1PDb9u/fuMFXRtcw8UajwmZ0AA9z78sVgVZcRaAJ+PM4XULJIAOkQoHrFReI4uLYxNm3m1IuG2JYTscvTqPOaqcPx3E33U27LKyg5ywOUydIB6iZG1NOZYNzM8W8j15/qV6tmHcf5A8IFoJycP10zXXDYEWpW7cKKQrqVUtmBBiI0G0b9K44HFlLwckhdUkgZoOvwzIn15nWvpeF3h/CtGRuEABPUgknkdvID0qu4vh7mFcG6sll+wDoDMhnES28xygSas4wO9U0GGo/gBknyFt9+skK34hiw0vzBUXI1AJJ1kaAH66CrPhuI71WnOVcn+IAcrtAGp5MIjU6wOUVR2Lf7y66tb8OoVAI0ghljYmDrOjc62+FyYcW7VoSgHigSCTqdZ1PoDXWVWuJvEG/wCs0ripoANLZOnLrl5foqlvdibF1+8ypoTIUZZMaZvFB1jy9ql2uzmFw471wAYghdJ1JAyr4SfQV+YbDNbLE3nCnTKIHKNdJ06giI8q/LzouojyP/u9PWoPqtieG/M2z2/Soms48PiHhtkIPlIy87+ahcS4Ph8QS62cjHXPrqRp4kIUHQ76HUa1Lw2GFm13ZcsuxBO502GyieX4kGouK42qLrBPmdP1r/pWO492nzSF9CefLY/l50sX+Idz6BAphnILRYjjFtDlOsjSOnKZ1Hyrnw/D3MbeFm2YVYN1/uKSTp/MZIUa6yeRrCYe9cdoFtmuOwCBdyTsAOs17v2G7PfuWGW22t1vHdaZljyB6KNB11POr8JgON8uyHvqqcVjeBkNzPsrvB4VLSLbtqFRQAoHID9b1IpSvQLCSlKUISlKUIXkf7VuzpS5+9JpbuEByP8Ad3PhUn+VxA/qHVhWY7P8aa2wRpBmCB08vb9TrXveMwiXUa3cUMjgqynYg714h207JPg21zPhyf4d7mhOy3I58gdm9dKy8bhZ/mMtfz+QtPB4mAGHpzWowPGSW0iYiR+JJJMRVh+9lwyswIOhymNx1H968sTidy2oBmJ0Zef66Va8M7Rwwk6DaCd9Y+vSPascMqtvNuR791pnwX6XXoOD4bYtqoWygiFl9MoGnv71bnF5kbuwBEQzCPLQaH5xWBwnaNHJlm0gAH9dfpVrb48GiCCY6nTr+vPTarG4hzJbl8n2t3BGSpfhA4g5qXwtLxRg1xmAIUsxJA02g7gn7Wp15ja/a0hsm21trgbUhgIPOeo1571SYTi4IGuvSdCPy358qnWeK6zm0MDcx/yir6GIt/IySOXUx+RbeLKOJpPechG3Y72zVSezllnko6w0ZA5IiJPiI29/yqw4twG2qnKkIRAC8tNTPn1qQnFTyY6GNRO8R+Om1feI4uRoQGHMEEeZgnoDQypTY036w3noD6wPIJT/ABOF38KYHr9/ysxw7htzDt3gd1OoyprmHLwnf085Hn2vsbWIFm5CI4LB12aPjVPugEzl3GY7VcvxNfC4tgQ2mux6iY9K+OM8TzW83gBUzmJ28wfefUCuCoxtM8JNr5Z/GfQ805xYlzxxRtpb5y5zC78O4thUMW1UEAwQCTOkgk+2lQuJ3BfY5kCp5gEnT6ddKyuJx1tAco1PMCCfX9f9+FnjOUSz+gEegJO5/wBaXOIe9oDrDYd97pj/ABmMdxAknndbGw1tFhdB5em5M6+p61CxfGBpDGNoOkawOm4/HnWN4j2nPIkzJ6+51+tZvF8aYzJgeZ1jyO50n1qxrajxDRCiXMaZJlei4vtGsZZ2/UfKazfEe0gAOXT3jT0GgG3Oskj3H+FSR95tB+pqQnDxvcbMenL5VI0Gg/zdPLv7qHjGIYF93uIXbxMSfPYD5b/QV+2MOFI3uOYCgCSTyCqNyegqw4PwnEYt+6wtstHxMdET+t9h6ak8ga9h7G9h7OC/iMe9xBEG6wgL1Ftfsjz3PWNA7QwzqnJqTrYgMzuVA/Z52KOGjEYkA4hh4V3FkHlOxcjcjbYcy2+pStVjGsHC3JZb3ueeJyUpSpKKUpShCUpShCVwxOHS4jI6q6MCGVgCCDuCDoRXelCF5X2k/ZxcQm5gSGQ74e4dR/5btoR/K23XlXn2KwKK5t3UezdG6kFT65Ty6EaHlX9K1W8X4Nh8UuTEWUuAbZhqvmrbqfMEUnVwTHXZY8k3Sxbm2dcL+d/9nOuqXAfXT6aiv1hiF+xmH8pn6A16fxT9lSzmwmIa3/JdHeL7Now981ZrH9jOJWf9yLo+9YcN/lbK3yBpCphazdA5OsxNI5OhZT/a1xD4sy+oP96k2+0zbzr57/PfaRXbE4q9Z/xrVy3/AOZbZP8AqAqP+/Wn1K2z5kD8qWcwD/ZiYFQ6OUy32mP3h6nWOftrrpXX/wCKTr+Y2jpEVVG3Yb/dr7SPwNfq4KwfsR/xEf3qHBS1B76qfi1OXfRTj2oMZQdJJifTzjl0r9XtSYKtAUg6yZ2OXn1iobYbCqJyZj/Ufzqq7uyg+FfU1IUaLsmnvqueNUGq6Ynjeb7RPlFcQ915hDHMsYr9THqTlXVidFXU+wFXvDuzvELw/hYK9HW4BaHzulZ9qabSd/wZ37Jd1Qf8nKlXhrEjO8dQo/ua7DD2kPhUTzJ1PzNbvhv7LMY5/j3rNofyTdb5eED1k1ruEfsxwFmDcV8Q3/jGV/8A1qApH9QNXNwlV3+xgd7Kl2JpNyuV5PwzBYjFHLhrL3eRKiFX+pzCj0Jmt52f/ZVJD467m/8ABskgf8dzRj6LG25r06zZVFCooVQICqIAHkBtXWm6WDp0+aVqYt78rKNgcHbsoLdpFtouyoAAPYVJpSmkqlKUoQlKUoQlKUoQlKUoQlKUoQlKUoQlKUoQvw1XYjgOFuf4mGsP/VaQ/iKUrhyQoF3sPw5v/s7I/pXL/wBMVHP7POG//ij/AJ7n/qpSuOY3ZT43bov7P+GrthVP9TO34sanYfsjgEMrgsMD17pJ+cUpRAGS45xjNW1jDIghEVR0UAfhXWlKkopSlKEJSlKEJSlKEJSlKEJSlKEJSlKEL//Z")
            viewModel.list()
        }

        adapter.onClick = {
            viewModel.delete(it)
            viewModel.list()
        }


    }

    companion object {
        @JvmStatic fun newInstance() =
                ShowFragment()
    }
}
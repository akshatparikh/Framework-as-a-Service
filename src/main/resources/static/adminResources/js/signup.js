function validate()
{
		//******First Name*******			
	    var a = document.getElementById("firstName");
		var a1 = document.getElementById("sfn1");
		var a2 = document.getElementById("sfn2");	
	    
		if(a.value=="")
		{
			a.style.border="1px solid red";
	        a1.style.display="";
	        a2.style.display="none";
	        return false;
		}
		else if(a.value.length < 3)
		{
	        a.style.border="1px solid red";
			a1.style.display="none";
	        a2.style.display="";
	        return false;
	    }
		
	    else
		{
	        a.style="display none";
			a1.style.display="none";
			a2.style.display="none";
	    }
		
		//******Middle Name*******			
	    var b = document.getElementById("middleName");
		var b1 = document.getElementById("smn1");
		var b2 = document.getElementById("smn2");	
	    
		if(b.value=="")
		{
			b.style.border="1px solid red";
	        b1.style.display="";
	        b2.style.display="none";
	        return false;
		}
		else if(b.value.length < 3)
		{
	        b.style.border="1px solid red";
			b1.style.display="none";
	        b2.style.display="";
	        return false;
	    }
		
	    else
		{
	        b.style="display none";
			b1.style.display="none";
			b2.style.display="none";
	    }
		
		//******Last Name*******			
	    var c = document.getElementById("lastName");
		var c1 = document.getElementById("sln1");
		var c2 = document.getElementById("sln2");	
		
		if(c.value=="")
		{
			c.style.border="1px solid red";
	        c1.style.display="";
	        c2.style.display="none";
	        return false;
		}
		else if(c.value.length < 3)
		{
			c.style.border="1px solid red";
			c1.style.display="none";
	        c2.style.display="";
	        return false;
	    }
		
	    else
		{
			c.style="display none";
			c1.style.display="none";
			c2.style.display="none";
	    }
		
		//******Occupation*******			
	    var o = document.getElementById("occupation");
		var o1 = document.getElementById("soc1");
		var o2 = document.getElementById("soc2");	
		
		if(o.value=="")
		{
			o.style.border="1px solid red";
	        o1.style.display="";
	        o2.style.display="none";
	        return false;
		}
		else if(o.value.length < 3)
		{
			o.style.border="1px solid red";
			o1.style.display="none";
	        o2.style.display="";
	        return false;
	    }
		
	    else
		{
			o.style="display none";
			o1.style.display="none";
			o2.style.display="none";
	    }
		
		//******Birth Date*******
		var g = document.getElementById("birthDate");
		var g1 = document.getElementById("sdob");
	    
		if(g.value=="")
		{
			g.style.border="1px solid red";
	        g1.style.display="";
	        return false;
		}
	    else
		{
	        g.style="display none";
			g1.style.display="none";
	    }
		
		//******Email*******			
	    var d = document.getElementById("email");
		var d1 = document.getElementById("sem1");
		var d2 = document.getElementById("sem2");	
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		
		if(d.value=="")
		{
			d.style.border="1px solid red";
	        d1.style.display="";
	        d2.style.display="none";
	        return false;
		}
		else if(!filter.test(d.value))
		{
			d.style.border="1px solid red";
			d1.style.display="none";
	        d2.style.display="";
	        return false;
	    }
		
	    else
		{
			d.style="display none";
			d1.style.display="none";
			d2.style.display="none";
	    }

		//******Phone Number*******
		var e = document.getElementById("mobile");
		var e1 = document.getElementById("spn1");
		var e2 = document.getElementById("spn2");	
	    
		if(e.value=="")
		{
			e.style.border="1px solid red";
	        e1.style.display="";
	        d2.style.display="none";
	        return false;
		}
		else if(e.value.length < 10)
		{
	        e.style.border="1px solid red";
			e1.style.display="none";
	        e2.style.display="";
	        return false;
	    }
	    else
		{
	        e.style="display none";
			e1.style.display="none";
			e2.style.display="none";
	    }

		//******Address*******
		var i = document.getElementById("address");
		var i1 = document.getElementById("sadd1");
		var i2 = document.getElementById("sadd2");
	    
		if(i.value=="")
		{
			i.style.border="1px solid red";
	        i1.style.display="";
	        i2.style.display="none";
	        return false;
		}
		else if(i.value.length < 10)
		{
	        i.style.border="1px solid red";
	        i1.style.display="none";
	        i2.style.display="";
	        return false;
	    }
	    else
		{
	        i.style="display none";
			i1.style.display="none";
			i2.style.display="none";
	    }

		//******Password*******
		var h = document.getElementById("password");
		var h1 = document.getElementById("spwd1");
		var h2 = document.getElementById("spwd2");	
	    
		if(h.value=="")
		{
			h.style.border="1px solid red";
	        h1.style.display="";
	        h2.style.display="none";
	        return false;
		}
		else if(h.value.length < 8)
		{
	        h.style.border="1px solid red";
			h1.style.display="none";
	        h2.style.display="";
	        return false;
	    }
	    else
		{
	        h.style="display none";
			h1.style.display="none";
			h2.style.display="none";
	    }
		
		//******Confirm Password*******
		var k = document.getElementById("confirmPassword");
		var k1 = document.getElementById("sconpwd1");
		var k2 = document.getElementById("sconpwd2");	
	    
		if(k.value=="")
		{
			k.style.border="1px solid red";
	        k1.style.display="";
	        k2.style.display="none";
	        return false;
		}
		else if(k.value != h.value)
		{
	        k.style.border="1px solid red";
			k1.style.display="none";
	        k2.style.display="";
	        return false;
	    }
	    else
		{
	        k.style="display none";
			k1.style.display="none";
			k2.style.display="none";
	    }
		
}
	
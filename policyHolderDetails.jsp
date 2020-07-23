<%-- 
    Document   : policyHolderDetails
    Created on : 9 Apr, 2020, 12:52:03 AM
    Author     : AKSHAY
--%>

<%@page import="daos.UserDao"%>
<%@page import="daos.PolicyDao"%>
<%@page import="daos.PolicyHolderAddressDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daos.PolicyHolderDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="beans.PolicyHolder,beans.PolicyHolderAddress,beans.Policy,beans.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row"> 
                <div class="col">
                    <h3>Your Personal Details :</h3>

                    <%

                        ArrayList<PolicyHolder> phList = new ArrayList();
                        User user = (User) session.getAttribute("user");
                        phList = (ArrayList<PolicyHolder>) session.getAttribute("pHolderList");
                        //session.setAttribute("phList", phList);
                        System.out.println("phlist in detail page:"+phList);
                        UserDao ud = new UserDao();
                        user = ud.getUserByEmailId(user.getEmail());
                        session.setAttribute("user", user);
                        int userid = user.getId();
                        System.out.println("userid in detail page:" + userid);
                         for (PolicyHolder pHolder : phList) {
                    %>
                    <div class="col-md-9">
                        <table class="table" style="border: 2px" >
                            <br>  Name : <%=pHolder.getName()%>
                            <br>  Father's Name : <%=pHolder.getFname()%>
                            <br>  Email : <%=pHolder.getEmail()%>
                            <br> Gender : <%=pHolder.getGender()%>
                            <br> contact : <%=pHolder.getContact()%>
                            <br> DOB : <%=pHolder.getDob()%>
                            <br>Occupation : <%=pHolder.getOccupation()%><br>
                            <%}%>
                            <h3>Your Address Details : </h3>
                            <%
                                //     PolicyHolderAddressDao phAddr = new PolicyHolderAddressDao();
                                // PolicyHolderAddress phAddress = phAddr.getAddressByPolicyHolderId(pHolder.getId());
                                PolicyHolderAddress phAddress = (PolicyHolderAddress) session.getAttribute("policyHolderAddress");

                            %>
                            <br>Locality :  <%=phAddress.getLocality()%>
                            <br>City : <%=phAddress.getCity()%>
                            <br>State : <%=phAddress.getState()%>
                            <br>Pincode : <%=phAddress.getPincode()%>

                            <h3> Your Policy Details :</h3> 
                            <%
                                //  PolicyDao pdo = new PolicyDao();
                                // Policy policy = pdo.getPolicyByPolicyHolderId(pHolder.getId());                           
                                Policy policy = (Policy) session.getAttribute("policy");
                                int total_premium = Integer.parseInt(policy.getMin_sum_assured()) / 100;
                            %>
                            <br>Policy Name : <%=policy.getName()%>
                            <br>Total Sum Assured : <%=policy.getMin_sum_assured()%>
                            <br> Time Duration : <%=policy.getMin_time_duration()%>
                            <br> Total premium : <%=Integer.parseInt(policy.getMin_sum_assured()) / 100%>


                        </table>  
                        <br>  <a href="payment.jsp?op=firstPayment&amount=<%=total_premium%>" class="btn btn-primary">Make Payment</a>
                    </div>

                </div>
            </div>
        </div>

    </body>
</html>

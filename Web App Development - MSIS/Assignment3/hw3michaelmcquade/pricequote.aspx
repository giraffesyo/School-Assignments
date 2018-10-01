<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="pricequote.aspx.cs" Inherits="hw3michaelmcquade.pricequote" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Price Quote</title>
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <script src="scripts/jquery-3.3.1.min.js"></script>
    <link href="Content/pricequote.css" rel="stylesheet" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<body>
    <form id="pricequote" runat="server">
        <div class="container">
            <h1 class="jumbotron">Price Quotation</h1>
            <div class="form-group row">
                <label class="col-5 col-sm-3 col-form-label">Sales Price:</label>
                <asp:TextBox step="0.01" CssClass="col-5 col-sm-3 form-control" ID="tbSalesPrice" runat="server" TextMode="Number"></asp:TextBox>
                <!--  Vertically aligning the validators with the label and control -->
                <div class="col-12 col-sm-6 vertical-align">
                    <asp:RequiredFieldValidator ID="rfvSalesPrice" runat="server" ErrorMessage="You must enter a sales price." ControlToValidate="tbSalesPrice" Display="Dynamic" CssClass="text-danger"></asp:RequiredFieldValidator>
                    <asp:RangeValidator ID="rvSalesPrice" runat="server" ErrorMessage="You must enter a price between 100 and 2500." ControlToValidate="tbSalesPrice" Display="Dynamic" CssClass="text-danger" MaximumValue="2500" MinimumValue="100" Type="Double"></asp:RangeValidator>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-5 col-sm-3 col-form-label discount-percent">Discount Percent:</label>
                <asp:TextBox CssClass="col-5 col-sm-3 form-control" ID="tbDiscountPercent" runat="server" TextMode="Number"></asp:TextBox>
                <!--  Vertically aligning the validators with the label and control -->
                <div class="col-12 col-sm-6 vertical-align">
                    <asp:RequiredFieldValidator CssClass="text-danger" ID="rfvDiscountPercent" runat="server" ErrorMessage="You must enter a percent to discount." Display="Dynamic" ControlToValidate="tbDiscountPercent"></asp:RequiredFieldValidator>
                    <asp:RangeValidator CssClass="text-danger" ID="rvDiscountPercent" runat="server" ErrorMessage="You must enter a discount between 5 percent and 75 percent." ControlToValidate="tbDiscountPercent" Display="Dynamic" MaximumValue="75" MinimumValue="5" Type="Double"></asp:RangeValidator>
                </div>
            </div>
            <!-- We're vertically aligning this because col-form-labels are vertically aligned
                 by bootstrap and we want our server Label to also be vertically aligned -->
            <div class="form-group row vertical-align">
                <label class="col-9 col-sm-3 col-form-label">Discount Amount:</label>
                <asp:Label CssClass="col-3 pl-0" ID="lblDiscountAmount" runat="server" Text="$0"></asp:Label>
            </div>

            <!-- We're vertically aligning this because col-form-labels are vertically aligned
                 by bootstrap and we want our server Label to also be vertically aligned -->
            <div class="form-group row vertical-align">
                <label class="col-9 col-sm-3 col-form-label">Total Price:</label>
                <asp:Label CssClass="col-3 pl-0 " ID="lblTotalPrice" runat="server" Text="$0"></asp:Label>
            </div>
            <div class="form-group row">
                <div class="col-12 col-sm-9 offset-sm-3 pl-sm-0">
                    <asp:Button CssClass="btn btn-primary ml-sm-auto" ID="btnCalculate" runat="server" Text="Calculate" OnClick="btnCalculate_Click" />
                </div>
            </div>
        </div>
    </form>
</body>
</html>

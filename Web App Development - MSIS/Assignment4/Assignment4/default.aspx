<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="default.aspx.cs" Inherits="Assignment4._default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <link href="Content/styles.css" rel="stylesheet" />
    <script src="scripts/jquery-3.3.1.min.js"></script>
    <title>Home Page</title>
</head>
<!-- Give body a class so we can use the same stylesheet for each page -->
<body class="default">
    <form id="form1" runat="server">
        <div class="container">
            <div class="jumbotron">
                <h1>Assignment 4 Main Color Page</h1>
                <h2>Main Page</h2>
            </div>
            <div class="row blue">
                <div class="col">
                    <p>Create a hyperlink on an entire block of color. Make the color of the block blue. The hyperlink should go to the blue page. The blue page needs a button to return to this page.</p>
                </div>
                <asp:HyperLink CssClass="col" runat="server" NavigateUrl="~/blue.aspx"></asp:HyperLink>
            </div>
            <div class="row green">
                <div class="col">
                    <p>Create a hyperlink button that is green. The hyperlink should go to the green page and pass the name of this page to it, and display this page name on the green page. The green page should return to this page.</p>
                </div>
                <div class="col">
                    <asp:LinkButton ID="lbGoToGreenPage" runat="server" OnClick="lbGoToGreenPage_Click">Go to Green Page</asp:LinkButton>
                </div>
            </div>
            <div class="row yellow">
                <div class="col">
                    <p>Create a button that is yellow. The clicked event of the button should use a Response.Redirect to go to the Yellow page. The yellow page should have an option to add a comment that is then returned to this page and displayed in a label sever control.</p>
                </div>
                <div class="col">
                    <asp:Button ID="btnGoToYellowPage" runat="server" Text="Go to Yellow Page" OnClick="btnGoToYellowPage_Click" />
                    <asp:Label ID="lblFromYellowPage" runat="server"></asp:Label>
                </div>
            </div>
        </div>
    </form>
</body>
</html>

<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="yellow.aspx.cs" Inherits="Assignment4.yellow" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <link href="Content/styles.css" rel="stylesheet" />
    <script src="scripts/jquery-3.3.1.min.js"></script>
    <title>Yellow Page</title>
</head>
<!-- Give body a class so we can use the same stylesheet for each page -->
<body class="yellowpage">
    <form id="form1" runat="server">
        <div class="container">
            <div class="jumbotron">
                <h1>I am the Yellow Page</h1>
            </div>
            <div class="row">
                <div class="col">
                    <label>Enter a message to return to the Main Page: </label>
                </div>
                <div class="col">
                    <asp:TextBox ID="tbMessageToMainPage" runat="server"></asp:TextBox>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col offset-6">
                    <asp:RequiredFieldValidator ID="rfvMessageToMainPage" runat="server" ErrorMessage="You must enter a message to the main page!" ControlToValidate="tbMessageToMainPage" Display="Dynamic" ForeColor="Red"></asp:RequiredFieldValidator>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col offset-6">
                    <asp:Button ID="btnReturnToMainPage" runat="server" Text="Return To Main Page" OnClick="btnReturnToMainPage_Click" />
                </div>
            </div>
        </div>
    </form>
</body>
</html>

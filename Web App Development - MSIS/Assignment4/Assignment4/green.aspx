<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="green.aspx.cs" Inherits="Assignment4.green" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <link href="Content/styles.css" rel="stylesheet" />
    <script src="scripts/jquery-3.3.1.min.js"></script>
    <title>Green Page</title>
</head>
<!-- Give body a class so we can use the same stylesheet for each page -->
<body class="greenpage">
    <form id="form1" runat="server">
        <div class="container">
            <div class="jumbotron">
                <h1>I am the Green Page</h1>
            </div>
            <div class="row">
                <div class="col">
                    <label>What is the name of the page you just came from:</label>
                </div>
                <div class="col">
                    <asp:Label ID="lblReferrer" runat="server"></asp:Label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col offset-6">
                    <asp:Button ID="btnReturnToMainPage" runat="server" Text="Return to Main Page" OnClick="btnReturnToMainPage_Click" />
                </div>
            </div>
        </div>
    </form>
</body>
</html>

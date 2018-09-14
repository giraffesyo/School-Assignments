<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="default.aspx.cs" Inherits="Homework2mcquade._default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Expense Reporting</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="scripts/jquery-3.3.1.min.js"></script>
    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <!-- I don't have my own css file because I had no need for custom styles -->
</head>
<body>
    <div class="container">
        <form id="form1" runat="server">
            <h1>Expense Report</h1>
            <div>
                <table class="table table-responsive table-borderless table-hover">
                    <!-- We use tbody so that bootstrap applies the hover to just the rows we want -->
                    <tbody>
                        <tr>
                            <td>Expense Type</td>
                            <td>
                                <asp:DropDownList ID="ddlExpenseType" runat="server">
                                </asp:DropDownList>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Date of Expense</td>
                            <td>
                                <!-- By swapping to TextMode Date we get an HTML 5 Date input box -->
                                <asp:TextBox TextMode="Date" ID="tbDateOfExpense" runat="server"></asp:TextBox>
                            </td>
                            <td>
                                <asp:RequiredFieldValidator ControlToValidate="tbDateOfExpense" ID="rfvDateOfExpense" runat="server" Display="Dynamic" ErrorMessage="You must choose a date for the expense." ForeColor="Red"></asp:RequiredFieldValidator>
                                <asp:RangeValidator ID="rvDateOfExpense" runat="server" ControlToValidate="tbDateOfExpense" Display="Dynamic" ErrorMessage="The expense must be from the current year and cannot be future dated." ForeColor="Red" Type="Date"></asp:RangeValidator>
                            </td>
                        </tr>
                        <tr>
                            <td>Expense Description</td>
                            <td>
                                <asp:TextBox placeholder="Lunch with potential client" ID="tbExpenseDescription" runat="server"></asp:TextBox>
                            </td>
                            <td>
                                <asp:RequiredFieldValidator ID="rfvExpenseDescription" runat="server" Display="Dynamic" ErrorMessage="You must enter a description for the expense." ForeColor="Red" ControlToValidate="tbExpenseDescription"></asp:RequiredFieldValidator>
                            </td>
                        </tr>
                        <tr>
                            <td>Expense Amount</td>
                            <td>
                                <asp:TextBox placeholder="0.00" ID="tbExpenseAmount" runat="server" TextMode="Number"></asp:TextBox>
                            </td>
                            <td>
                                <asp:RequiredFieldValidator ID="rfvExpenseAmount" runat="server" Display="Dynamic" ErrorMessage="You must enter an expense amount." ForeColor="Red" ControlToValidate="tbExpenseAmount"></asp:RequiredFieldValidator>
                            </td>
                        </tr>
                    </tbody>
                    <!-- Our tfoot won't have the bootstrap hover effect -->
                    <tfoot>
                        <!-- Bold our Summary row so that it stands out! -->
                        <tr class="font-weight-bold">
                            <td>SUMMARY</td>
                            <td>
                                <asp:Label ID="labelSummary" runat="server"></asp:Label>
                            </td>

                            <td>&nbsp;</td>
                        </tr>


                        <tr>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>
                                <asp:Button CssClass="btn btn-primary" ID="btnSubmit" runat="server" Text="Submit" OnClick="btnSubmit_Click" />
                            </td>
                            <td>
                                <asp:Button CssClass="btn " ID="btnClear" runat="server" Text="Clear Form" CausesValidation="False" OnClick="btnClear_Click" />
                            </td>
                            <td>&nbsp;</td>
                        </tr>
                    </tfoot>
                </table>

            </div>
        </form>
    </div>
</body>
</html>

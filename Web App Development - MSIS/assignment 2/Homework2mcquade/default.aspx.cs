using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Homework2mcquade
{
    public partial class _default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                //Creates minimum value with current year from DateTime object and january first hard coded. 
                //This way we only ever allow submissions from current year
                rvDateOfExpense.MinimumValue = new DateTime(DateTime.Now.Year, 1, 1).ToShortDateString();
                //Create maximum value using current date, so we do not allow future dated submissions. 
                rvDateOfExpense.MaximumValue = DateTime.Now.ToShortDateString();
                //Define our expense types
                String[] ExpenseTypes = { "Airfare", "Meal", "Lodging", "Mileage", "Toll" };
                //Add all our expense types to our drop down list
                //ExpenseTypes is looped over by using the Select method, which accepts a function as a parameter
                //We create an anonymous function that is passed to the Select method, this anonymous function returns a 
                //Generic collection of ListItems.
                //We cast this generic collection to be of type ListItem and then call the ToArray method in order to return
                //an array of List Items to the AddRange() method. 
                ddlExpenseType.Items.AddRange(ExpenseTypes.Select(ExpenseType => new ListItem(ExpenseType)).Cast<ListItem>().ToArray());
            }
        }

        protected void btnClear_Click(object sender, EventArgs e)
        {
            tbDateOfExpense.Text = "";
            tbExpenseAmount.Text = "";
            tbExpenseDescription.Text = "";
            ddlExpenseType.SelectedIndex = 0;

        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            //If all the validators passed
            if (IsValid)
            {
                //Set the summary to be a string based off our text.
                //We cast to double so we can parse as currency
                labelSummary.Text = $"{ddlExpenseType.SelectedValue}, {tbDateOfExpense.Text}, {tbExpenseDescription.Text}, {Double.Parse(tbExpenseAmount.Text):c}";
            }
        }
    }
}
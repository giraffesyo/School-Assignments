using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Assignment4
{
    public partial class _default : System.Web.UI.Page
    {
        private String thisPage = "Main Page";
        private String YellowMessage;

        protected void Page_Load(object sender, EventArgs e)
        {
            //If Session["YellowMessage"] is null then ToString is never called, returning null to the null coalescing operator ??
            //When the null coalescing operator receives null for its left hand side value, it returns the value on the left
            //This ensures that the YellowMessage variable will always have a string inside of it.
            YellowMessage = Session["YellowMessage"]?.ToString() ?? "Replace this text with message from Yellow Page";
            lblFromYellowPage.Text = YellowMessage;
        }

        protected void lbGoToGreenPage_Click(object sender, EventArgs e)
        {
            Session["referrer"] = thisPage;
            Response.Redirect("~/green.aspx");
        }

        protected void btnGoToYellowPage_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/yellow.aspx");
            
        }
    }
}
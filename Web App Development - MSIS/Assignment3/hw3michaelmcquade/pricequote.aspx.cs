using System;

namespace hw3michaelmcquade
{
    public partial class pricequote : System.Web.UI.Page
    {
        protected void btnCalculate_Click(object sender, EventArgs e)
        {
            //Get values from text boxes for price and discount
            double price = Double.Parse(tbSalesPrice.Text);
            double discount = int.Parse(tbDiscountPercent.Text);
            // Calculate discount amount
            double discountamount = price * discount / 100;
            // Calculate total price
            double totalprice = price - discountamount;
            // Format the values as currency and display them on the labels
            lblDiscountAmount.Text = discountamount.ToString("C");
            lblTotalPrice.Text = totalprice.ToString("C");
        }
    }
}
package com.hueged.hashedin.Order.Service.Config;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hueged.hashedin.Order.Service.Entity.Order;
import com.hueged.hashedin.Order.Service.Entity.OrderDto;

@Component
public class MailConfig {

	
	public String sendMail(OrderDto order) {
	            try {
	               
	                // Start HTML message with a table
	                StringBuilder htmlMsg = new StringBuilder();
	                htmlMsg.append("<h1> Restaurant Name :").append(order.getCardDetails().getRestaurantName()).append("</h1>");
	                htmlMsg.append("<h1> Restaurant Email : ").append(order.getCardDetails().getRestaurantEmail()).append("</h1>");
	                htmlMsg.append("<table border='1'>");
	                htmlMsg.append("<tr><th>Category Name</th><th>Food Name</th><th>Price</th></tr>");

	                // Loop through order items to add rows to the table

	                    htmlMsg.append("<tr><td>").append(order.getCardDetails().getCategoryName()).append("</td>");
	                    htmlMsg.append("<td>").append(order.getCardDetails().getFoodName()).append("</td>");
	                    htmlMsg.append("<td>").append(order.getCardDetails().getPrice()).append("</td></tr>");


	                htmlMsg.append("</table>");
	                htmlMsg.append("<h1>Thank you !! </h1>");
	                // Use HtmlEmail instead of SimpleEmail
	                HtmlEmail email = new HtmlEmail();
	                email.setHostName("smtp.googlemail.com");
	                email.setSmtpPort(465);
	                email.setAuthenticator(new DefaultAuthenticator("manishghalme1997@gmail.com", "vhlk kdit supq drbn"));
	                email.setSSLOnConnect(true);
	                email.setFrom("");
	                email.setSubject("Order Booked");

	                // Set the HTML message
	                email.setHtmlMsg(htmlMsg.toString());

	                // Add recipient
	              

	                // Send the email
	                email.send();
	                System.out.println("Email sent!");
	            } catch (EmailException e) {
	                e.printStackTrace();
	            }
	            return "Email Send";

	}
	
//	@Scheduled(cron = "0 * * * * *") 
	public void sendMail() {

		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("manishghalme1997@gmail.com", "vhlk kdit supq drbn"));
			email.setSSLOnConnect(true);
			email.setFrom("manishghalme1997@gmail.com");
			email.addTo("");
			// Email subject
			email.setSubject("Order Confirmation");

			// Constructing the email message
			String customerName = "Shahnawaz, Md.";
			String companyName = "Navnath Hotel";
			String orderNumber = "NNV345";
			String orderDate = "02/08/2024";
			String totalAmount = "500";
			String customerAddress = "Jalna";
			String deliveryDate = "02/08/2024";
			String trackingLink = "nonvis";
			String contactInfo = "7219232301";

			String message = String.format("Dear %s,\n\n"
					+ "Thank you for your order with %s! We are excited to let you know that your order %s has been successfully processed and is now being prepared for shipment. Below you will find the details of your order for your review.\n\n"
					+ "Order Details:\n\n" + "Order Number: %s\n" + "Date: %s\n" + "Total Amount: %s\n"
					+ "Items Ordered:\n" + "Black forest - 1 x 400\n" + "Dark chochalate - 5 x 10 \n" + "Shipping Address: %s\n\n"
					+ "Estimated Delivery Date: %s (You can track your order here: http://example.com/track/123456 %s)\n\n"
					+ "We will send you another email once your items have shipped. If you have any questions or need to make changes to your order, please contact us at %s as soon as possible. We are here to help!\n\n"
					+ "Thank you for choosing %s. We hope you enjoy your purchase!\n\n" + "Warm regards,", customerName,
					companyName, orderNumber, orderNumber, orderDate, totalAmount, customerAddress, deliveryDate,
					trackingLink, contactInfo, companyName);

			// Set the email message
			email.setMsg(message);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
		System.out.print("mail send");
	}


	public void sendMail(Order order) {
		
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("manishghalme1997@gmail.com", "vhlk kdit supq drbn"));
			email.setSSLOnConnect(true);
			email.setFrom("manishghalme1997@gmail.com");
			email.addTo("mshahnawaz@deloitte.com");
			// Email subject
			email.setSubject("Order Delivered");
			String message ="We are pleased to inform you that your order NNA0234 has been successfully delivered! We hope you are excited to receive your items and we look forward to providing you with the best possible experience.";
			// Set the email message
			email.setMsg(message);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
			

	}
	
}

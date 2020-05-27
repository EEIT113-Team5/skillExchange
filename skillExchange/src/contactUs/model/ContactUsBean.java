package contactUs.model;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ContactUs")
public class ContactUsBean {
	private int contactNo;
	private int memberRegNo;
	private String contactUser;
	private String email;
	private String title;
	private String content;
	private int isReply;
	private String replyContent;

	public ContactUsBean(int memberRegNo, String contactUser, String email, String title, String content,String replyContent) {
		this.memberRegNo = memberRegNo;
		this.contactUser = contactUser;
		this.email = email;
		this.title = title;
		this.content = content;
		this.replyContent = replyContent;
	}

	public ContactUsBean() {
	}

	@Id
	@Column(name = "contactNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "memberRegNo")
	public int getMemberRegNo() {
		return memberRegNo;
	}

	public void setMemberRegNo(int memberRegNo) {
		this.memberRegNo = memberRegNo;
	}

	@Column(name = "contactUser")
	public String getContactUser() {
		return contactUser;
	}

	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(", memberRegNo=");
		builder.append(memberRegNo);
		builder.append(", contactUser=");
		builder.append(contactUser);
		builder.append(", email=");
		builder.append(email);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}

	public void senEmail(ContactUsBean cntUs) throws MessagingException {
		String subject;
		String mailContent;
		if(cntUs.getReplyContent()!=null) {
			 subject = "管理者已回覆您的留言！";
			 mailContent = "<div style='font-family:微軟正黑體;'>"
						+"<fieldset style='margin: auto;border:	#0066CC solid 1px;border-radius: 15px;width: 700px;background:#FFFFF4;'>"
		            +"<h3 style='color:	#5B5B5B;text-align: center;margin: 2px;'>Skill Exchange</h3>"
		            +"<hr style='color: gray;'><div>"
		            +"親愛的"+contactUser+"：<br>您的留言內容如下：<p>"+content+"</p></div>"
		            +"<hr style='color: gray;'><div>管理員回覆內容如下：<p>"+replyContent+"</p></div>"
		            +"<hr style='color: gray;'><div style='text-align: center;'>"
		            +"<span style='color:blue;'>您的支持是我們進步的動力！！！</span><br>"
		            + "<span style='color:red;'>此為系統訊息，請勿回覆。</span><br></div></fieldset></div>";
		}else {
			subject = "感謝您的留言，我們將盡快回覆！";
			mailContent = "<div style='font-family:微軟正黑體;'>"
					+"<fieldset style='margin: auto;border:	#0066CC solid 1px;border-radius: 15px;width: 700px;background:#FFFFF4;'>"
	            +"<h3 style='color:	#5B5B5B;text-align: center;margin: 2px;'>Skill Exchange</h3>"
	            +"<hr style='color: gray;'><div>"
	            +"親愛的"+contactUser+"：<br>已收到您的留言，內容如下：<p>"+content+"</p></div>"
	            +"<hr style='color: gray;'><div style='text-align: center>"
	            +"<span>感謝您的支持，我們將盡快回覆！！！</span><br>"
	            + "<span style='color:red;'>此為系統訊息，請勿回覆。</span><br></div></fieldset></div>";
		}
		String username = "skillexchange2020";
		String password = "eeit11305";
		String contentType = "text/html;charset=UTF-8";
		
		
            
		


		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true"); // TLS
		Session mailSession = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Transport transport = mailSession.getTransport();

		MimeMessage message = new MimeMessage(mailSession);
		message.setSubject(subject);
		message.setContent(mailContent,contentType);
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

		transport.connect();
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();

	}

	@Column(name = "isReply")
	public int getIsReply() {
		return isReply;
	}

	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}

	@Column(name = "replyContent")
	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

}

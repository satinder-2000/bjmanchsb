package org.bjm.services;

import org.bjm.entities.Access;
import org.bjm.entities.Blog;
import org.bjm.entities.Forum;
import org.bjm.entities.LokSabhaNominate;
import org.bjm.entities.Survey;
import org.bjm.entities.SurveyFromForum;
import org.bjm.entities.User;
import org.bjm.entities.VidhanSabhaNominate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
	
	@Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;
    @Value("${webURI}")
    private String webURI;
    @Value("${createAccessURI}")
    private String createAccessURI;
    @Value("${forumCreatedURI}")
    private String forumCreatedURI;
    @Value("${surveyCreatedURI}")
    private String surveyCreatedURI;
    @Value("${surveyCreatedFromForumURI}")
    private String surveyCreatedFromForumURI;
	
	public void sendUserRegisteredEmail(Access access) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper=null;
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(sender);
            helper.setTo(access.getEmail());
            
            StringBuilder htmlMsg = new StringBuilder("<html><body>");
            htmlMsg.append("<h2>Dear, ").append(access.getEmail()).append("</h2>");
            htmlMsg.append("<p>Congratulations on registering yourself successfully with us !!").append(".</p>");
            htmlMsg.append("<p>As a final step, please create your account password by following the link below:</p>");
            String createAccess = String.format(createAccessURI, access.getEmail());
            htmlMsg.append("<a href=\"").append(webURI).append(createAccess).append("\">")
            .append(webURI).append(createAccess)
            .append("</a>");

            htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
            htmlMsg.append("</body></html>");
            helper.setText(htmlMsg.toString());
            helper.setSubject("User Registration");
            javaMailSender.send(mimeMessage);
            LOGGER.info(String.format("UserRegisteredEmail sent to %s", access.getEmail()));
                
            	
            }catch (MessagingException e) {
            	e.printStackTrace();
            }
            
    }
	
	public void sendAccessCreatedEmail(Access access) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(access.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
			htmlMsg.append("<h2>Dear, ").append(access.getEmail()).append("</h2>");
			htmlMsg.append("<p>Congratulations on completing your access details successfully!!").append(".</p>");
			htmlMsg.append("<p>You may now proceed to the website and login to your account.</p>");
			htmlMsg.append("<a href=\"").append(webURI).append("\">").append(webURI).append("</a>");
			htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
			htmlMsg.append("</body></html>");
			helper.setText(htmlMsg.toString());
			helper.setSubject("User Registration - Access Confirmed!!");
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendAccessCreatedEmail sent to %s", access.getEmail()));
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
    }
	
	public void sendForumCreatedEmail(Access access, Forum forum) {
        try {
        	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(access.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
	        htmlMsg.append("<h2>Dear, ").append(access.getEmail()).append("</h2>");
	        htmlMsg.append("<p>Congratulations on creating a new Forum successfully!!").append(".</p>");
	        htmlMsg.append("<p>You may wish to view your Forum at the link provided below:</p>");
	        String forumCreated = String.format(forumCreatedURI, forum.getId(), access.getEmail());
	        htmlMsg.append("<a href=\"").append(webURI).append(forumCreated).append("\">")
	                .append(webURI).append(forumCreated)
	                .append("</a>");
	        //htmlMsg.append("<p>"+accessCreate+"</p>");
	        htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
	        htmlMsg.append("</body></html>");
	        helper.setText(htmlMsg.toString());
			helper.setSubject("Forum created Successfully - "+forum.getTitle());
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendForumCreatedEmail sent to %s", access.getEmail()));
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
	
	public void sendSurveyCreatedEmail(Access access, Survey survey) {
		try {
        	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(access.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
	        htmlMsg.append("<h2>Dear, ").append(access.getEmail()).append("</h2>");
	        htmlMsg.append("<p>Congratulations on creating a new Survey successfully!!").append(".</p>");
	        htmlMsg.append("<p>You may wish to view your Survey at the link provided below:</p>");
	        String surveyCreated = String.format(surveyCreatedURI, survey.getId(), access.getEmail());
	        htmlMsg.append("<a href=\"").append(webURI).append(surveyCreated).append("\">")
	                .append(webURI).append(surveyCreated)
	                .append("</a>");
	        //htmlMsg.append("<p>"+accessCreate+"</p>");
	        htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
	        htmlMsg.append("</body></html>");
	        helper.setText(htmlMsg.toString());
			helper.setSubject("Survey created Successfully - "+survey.getTitle());
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendSurveyCreatedEmail sent to %s", access.getEmail()));
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        
    }
	
	
	public void sendSurveyCreatedFromForumEmail(Access access, SurveyFromForum surveyFromForum) {
		try {
        	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(access.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
	        htmlMsg.append("<h2>Dear, ").append(access.getEmail()).append("</h2>");
	        htmlMsg.append("<p>Congratulations on creating a new Survey From Forum successfully!!").append(".</p>");
	        htmlMsg.append("<p>You may wish to view your Survey From Forum at the link provided below:</p>");
	        String surveyCreated = String.format(surveyCreatedFromForumURI, surveyFromForum.getId(), access.getEmail());
	        htmlMsg.append("<a href=\"").append(webURI).append(surveyCreated).append("\">")
	                .append(webURI).append(surveyCreated)
	                .append("</a>");
	        //htmlMsg.append("<p>"+accessCreate+"</p>");
	        htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
	        htmlMsg.append("</body></html>");
			helper.setSubject("Survey From Forum created Successfully - "+surveyFromForum.getTitle());
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendSurveyCreatedFromForumEmail sent to %s", access.getEmail()));
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
	}
	
	
	public void sendPasswordChangedEmail(Access access) {
		
		try {
        	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(access.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
	        htmlMsg.append("<h2>Dear, ").append(access.getEmail()).append("</h2>");
	        htmlMsg.append("<p>You have successfully changed your password.");
	        htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
	        htmlMsg.append("</body></html>");
			helper.setSubject("Password changed");
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendPasswordChangedEmail sent for %s", access.getEmail()));
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        
    }
	
	public void sendUserStateChangedEmail(User user) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(user.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
			htmlMsg.append("<h2>Dear, ").append(user.getEmail()).append("</h2>");
			htmlMsg.append("<p>You have successfully changed your State to ").append(user.getStateName())
					.append(".</p>");
			htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
			htmlMsg.append("</body></html>");
			helper.setSubject("State of residence changed");
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendPasswordChangedEmail sent for %s", user.getEmail()));

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
    }
	
	
	public void sendUserPersonalDetailsChangedEmail(User user) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(user.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
	        htmlMsg.append("<h2>Dear, ").append(user.getEmail()).append("</h2>");
	        htmlMsg.append("<p>You have successfully changed your Peronal Details.").append(".</p>");
	        htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
	        htmlMsg.append("</body></html>");
			helper.setSubject("Personal details changed");
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendUserPersonalDetailsChangedEmail sent for %s", user.getEmail()));

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendBlogCreatedEmail(Access access, Blog blog) {
		
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(access.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
	        htmlMsg.append("<h2>Dear, ").append(access.getEmail()).append("</h2>");
	        htmlMsg.append("<p>You have successfully published a new Blog ").append(blog.getTitle());
	        htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
	        htmlMsg.append("</body></html>");
			helper.setSubject("Blog Published "+blog.getTitle());
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendBlogCreatedEmail sent for %s", access.getEmail()));

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendContactUsEmail(String userEmail, String subject, String message) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(userEmail);
			helper.addCc(sender);
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
	        htmlMsg.append("<h2>Dear, ").append(sender).append("</h2>");
	        htmlMsg.append("<p>Please address the following feedback from ").append(userEmail).append(" on urgent basis.");
	        htmlMsg.append("<br/><p>").append(message).append("</p><br/>");
	        htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
	        htmlMsg.append("</body></html>");
			helper.setSubject(subject);
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendContactUsEmail sent for %s", userEmail));

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendNewLokSabhaNominationEmail(User user, LokSabhaNominate lokSabhaNominate) {
		
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(user.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
	        htmlMsg.append("<h2>Dear, ").append(user.getEmail()).append("</h2>");
	        htmlMsg.append("<p>You have successfully nominated new Candidate ").append(lokSabhaNominate.getCandidateName()).append(" for your Constituency ").append(user.getLokSabhaConstituency());
	        htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
	        htmlMsg.append("</body></html>");
	        helper.setSubject("New Lok Sabha Nomination");
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendNewLokSabhaNominationEmail sent for %s", user.getEmail()));

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		
    }
	
	public void sendLokSabhaReNominationEmail(User user, LokSabhaNominate lokSabhaNominate) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(user.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
	        htmlMsg.append("<h2>Dear, ").append(user.getEmail()).append("</h2>");
	        htmlMsg.append("<p>You have successfully nominated Candidate ").append(lokSabhaNominate.getCandidateName()).append(" for your Constituency ").append(user.getLokSabhaConstituency());
	        htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
	        htmlMsg.append("</body></html>");
	        helper.setSubject("Lok Sabha Nomination");
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendLokSabhaReNominationEmail sent for %s", user.getEmail()));

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
    }
	
	public void sendNewVidhanSabhaNominationEmail(User user, VidhanSabhaNominate vidhanSabhaNominate) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = null;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(sender);
			helper.setTo(user.getEmail());
			StringBuilder htmlMsg = new StringBuilder("<html><body>");
	        htmlMsg.append("<h2>Dear, ").append(user.getEmail()).append("</h2>");
	        htmlMsg.append("<p>You have successfully nominated new Candidate ").append(vidhanSabhaNominate.getCandidateName()).append(" for your Constituency ").append(user.getVidhanSabhaConstituency());
	        htmlMsg.append("<p>Best Wishes, <br/>").append(sender).append("</p>");
	        htmlMsg.append("</body></html>");
	        helper.setSubject("New Vidhan Sabha Nomination");
			javaMailSender.send(mimeMessage);
			LOGGER.info(String.format("sendNewVidhanSabhaNominationEmail sent for %s", user.getEmail()));

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		
	}

}

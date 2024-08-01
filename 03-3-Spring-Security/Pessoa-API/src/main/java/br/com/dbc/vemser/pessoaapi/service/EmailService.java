package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCompletoDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    //@Value("${mail.pessoa.criar}")
    private String pessoaCriada;

    private String mensagemCriacaoPessoa;

    @Value("${spring.mail.username}")
    private String de;

    private String para;

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(de);
        message.setTo(para);
        message.setSubject("Assunto");
        message.setText("Teste\n minha mensagem \n\nAtt,\nSistema.");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(de);
        helper.setTo(para);
        helper.setSubject("Assunto");
        helper.setText("Teste\n minha mensagem \n\nAtt,\nSistema.");

        File file1 = new File("imagem.jpg");
        FileSystemResource file
                = new FileSystemResource(file1);
        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);
    }

    public void sendEmail(PessoaCompletoDTO pessoaCompletoDto) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            String templatePessoaCriada = "email-template.ftl";

            mimeMessageHelper.setFrom(de);
            para = pessoaCompletoDto.getEmail();
            mimeMessageHelper.setTo(para);
            mimeMessageHelper.setSubject("Cadastro bem sucedido.");
            mimeMessageHelper.setText(geContentFromTemplate(templatePessoaCriada, pessoaCompletoDto), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public void sendEmail(PessoaCompletoDTO pessoaCompletoDto, EnderecoDTO enderecoDTO, String assunto, String modificacao) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            String templateEmail = "email-template-post-endereco.ftl";

            mimeMessageHelper.setFrom(de);
            para = pessoaCompletoDto.getEmail();
            mimeMessageHelper.setTo(para);
            mimeMessageHelper.setSubject(assunto);
            mimeMessageHelper.setText(geContentFromTemplate(templateEmail, enderecoDTO, pessoaCompletoDto, modificacao), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate(String s, PessoaCompletoDTO pessoaCompletoDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("email", de);
        dados.put("nome", pessoaCompletoDTO.getNome());
        dados.put("id", pessoaCompletoDTO.getIdPessoa());

        Template template = fmConfiguration.getTemplate(s);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String geContentFromTemplate(String s, EnderecoDTO enderecoDTO, PessoaCompletoDTO pessoaCompletoDTO, String modificacao) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaCompletoDTO.getNome());
        dados.put("modificacao", modificacao);
        dados.put("email", de);
//        dados.put("id", enderecoDTO.getIdPessoa());
        dados.put("logradouro", enderecoDTO.getLogradouro());
        dados.put("numero", enderecoDTO.getNumero());
        dados.put("complemento", enderecoDTO.getComplemento());
        dados.put("cep", enderecoDTO.getCep());
        dados.put("cidade", enderecoDTO.getCidade());
        dados.put("estado", enderecoDTO.getEstado());
        dados.put("pais", enderecoDTO.getPais());

        Template template = fmConfiguration.getTemplate(s);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

}

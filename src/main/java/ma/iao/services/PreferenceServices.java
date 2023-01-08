package ma.iao.services;

import ma.iao.repository.PreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PreferenceServices {
    @Autowired
    private PreferenceRepository preferenceRepository;
}
